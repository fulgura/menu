package com.dmc.service


class LoggingInterceptor {

    LoggingInterceptor() {
        matchAll()
    }

    boolean before() {

        log.info "preHandle " +
                "'$request.servletPath'/'$request.forwardURI', " +
                "from $request.remoteHost ($request.remoteAddr) " +
                " at ${new Date()}, Ajax: $request.xhr, controller: $controllerName, " +
                "action: $actionName, params: ${new TreeMap(params)}"
        
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
