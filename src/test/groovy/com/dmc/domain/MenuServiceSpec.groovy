package com.dmc.domain

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MenuService)
@Mock([Menu, Item])
class MenuServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test can find all active sub menus"() {
        given:
        def menuCaldoGallego = new Menu(description: "Caldo Gallego")
        def subMenu1 = new Menu(description: "SubMenu 1", enabled: true).save(failOnError: true)
        menuCaldoGallego.addToSubMenus(subMenu1)
        def subMenu2 = new Menu(description: "SubMenu 2", enabled: false).save(failOnError: true)
        menuCaldoGallego.addToSubMenus(subMenu2)
        def subMenu3 = new Menu(description: "SubMenu 3", enabled: true).save(failOnError: true)
        menuCaldoGallego.addToSubMenus(subMenu3)
        def subMenu4 = new Menu(description: "SubMenu 4", enabled: false).save(failOnError: true)
        menuCaldoGallego.addToSubMenus(subMenu4)

        menuCaldoGallego.save(failOnError: true)

        when:
        def actives = service.activeSubMenus(menuCaldoGallego)

        then:
        actives.size() == 2
    }

    void "test can sum all item prices"() {
        expect: "fix me"
        true == false
    }

}
