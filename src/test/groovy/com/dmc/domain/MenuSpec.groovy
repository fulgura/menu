package com.dmc.domain

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Menu)
class MenuSpec extends Specification {

    /**
     * run before every feature method
     */
    def setup() {}

    /**
     * run after every feature method
     */
    def cleanup() {}
    /**
     * run before the first feature method
     */
    def setupSpec() {}
    /**
     *  run after the last feature method
     */
    def cleanupSpec() {}

    @Unroll
    void "test can create a valid Menu with description:'#description' "() {

        expect: "is a valid Menu"
        new Menu(description: description).validate() == valid

        where: " fields are"
        description     || valid
        "Milanesa Napo" || true
        "Caldo"         || true
        null            || false
        ""              || false

    }
}
