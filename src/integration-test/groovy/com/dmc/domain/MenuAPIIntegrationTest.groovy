package com.dmc.domain

import grails.test.mixin.Mock
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
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




}
