package com.dmc.domain

import grails.converters.JSON
import grails.test.mixin.Mock
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import grails.web.mime.MimeType
import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification


/**
 * Integration test for REST API results
 */
@Integration
@Rollback
@Mock([Menu, Item])
class MenuAPIIntegrationTest extends Specification {

    @Shared
    def grailsApplication

    @Value('${local.server.port}')
    Integer serverPort

    RESTClient rest

    def setup() {
        assert Menu.count == 0
        assert Item.count == 0

        rest = new RESTClient("http://localhost:${serverPort}${grailsApplication.config['server.contextPath']}/")
    }

    def cleanup() {
        Menu.where { id != null }.deleteAll()
        Item.where { id != null }.deleteAll()
    }

    void "test can request menu list"() {
        given:
        def menu = new Menu(description: "Milanesa Napo").save()

        when:
        def response = rest.get(path: "api/menus")

        then:
        with(response) {
            status == HttpStatus.OK.value()
            contentType == MimeType.JSON.name
            data == ([menu] as JSON)
        }
    }

}
