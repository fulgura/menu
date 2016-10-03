package com.dmc.domain

import grails.converters.JSON

class MenuAPIController {

    /**
     *
     * Listing all menus.
     *
     * @return
     */
    def list() {
        render Menu.list() as JSON
    }
    /**
     *
     * List all items for a menu ordering by String content. Default order is by price
     *
     * @param menu
     * @param order
     */
    def show(Menu menu, String order) {

        def groupedItems = [:]

        if(!menu){



            render groupedItems as JSON
        } else {


        }
    }
}
