package com.dmc.domain

import grails.converters.JSON

class MenuAPIController {

    /**
     *
     * Listing all menus.
     *
     * @return
     */
    def apiIndex() {
        render Menu.list() as JSON
    }
}
