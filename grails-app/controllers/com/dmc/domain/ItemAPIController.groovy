package com.dmc.domain

import grails.converters.JSON

class ItemAPIController {

    /**
     *
     * Listing all Items.
     *
     * @return
     */
    def list() {
        render Item.list() as JSON
    }
}
