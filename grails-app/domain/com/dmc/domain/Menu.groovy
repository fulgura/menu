package com.dmc.domain

import groovy.transform.ToString

/**
 *
 * Restaurant menu model. It reflects a menu with their items and submenu.
 *
 *
 */
@ToString(includeNames = true, includeFields = true, excludes = "metaClass,class")
class Menu extends Entity {

    /**
     * Menu description
     */
    String description
    Boolean enabled = false

    static hasMany = [items: Item, subMenus: Menu]

    static constraints = {
        description nullable: false, maxSize: 2048
        enabled nullable: false
    }
}
