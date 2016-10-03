package com.dmc.domain

import grails.transaction.Transactional

@Transactional
class MenuService {

    /**
     *
     * Find all sub menus for a menu
     *
     * @param menu
     * @return
     */
    def activeSubMenus(Menu menu) {
        menu.subMenus.findAll { it.enabled }
    }

    /**
     *
     * Sum price items for a menu.
     *
     * @param menu
     */
    def totalPrice(Menu menu) {
        menu.items.each { Item item ->
            menu.price
        }
    }

}
