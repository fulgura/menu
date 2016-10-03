package com.dmc.domain

import grails.converters.JSON
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.BAD_REQUEST

/**
 *
 * Base API controller. It manages dispatched responses using Command pattern
 *
 */
class APIBaseController {

    def benchmark = { def customMetric, def closure ->
        def start = System.currentTimeMillis()
        closure.call()
        def now = System.currentTimeMillis()
        def time = now - start
        log.info("Time processing an ${customMetric}: ${time}")
        time
    }

    protected dispatch = { def command, HttpStatus code ->

        def dispatcherMap = [NO_CONTENT: { def cmd ->
            cmd.execute()
            []
        }].withDefault { httpCode -> { def cmd -> cmd.execute() } }

        def apiResponse = [code: code, errors: [], response: []]

        if (command.validate()) {
            apiResponse.response = dispatcherMap[code](command)
        } else {
            apiResponse.errors = formatErrors(command.errors*.allErrors)
            apiResponse.code = BAD_REQUEST
        }

        response.setStatus(apiResponse.code.value())
        response.setHeader 'X-Errors', (apiResponse.errors as JSON).toString()
        response.setContentType("application/json; charset=utf8")
        render apiResponse.response as JSON
    }

    static formatErrors(def allErrors) {
        allErrors.flatten().collect { [field: it.field, rejectedValue: it.rejectedValue] }
    }

}
