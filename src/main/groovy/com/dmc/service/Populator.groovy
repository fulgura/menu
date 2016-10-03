package com.dmc.service

/**
 * Populator interface defines method for populating database that will be defined based on environment.
 */
interface Populator {

    /**
     *
     * Initial population. Creates all necessary data for menus and items that system needs.
     *
     * @return
     */
    def populateInitialMenu()

}