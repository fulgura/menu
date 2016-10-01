package com.dmc.domain
/**
 *
 * Restaurant menu model. It reflects a menu with their items and submenu.
 *
 *
 */
class Menu extends Domain {

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
