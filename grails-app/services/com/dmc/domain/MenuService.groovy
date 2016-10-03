package com.dmc.domain

import com.dmc.valueobject.Money
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
        if (menu.items) {

            Money total = Money.valueOf(new BigDecimal(0), menu.items.first().price.currency)
            menu.items.each { Item item ->
                total.plus(item.price)
            }

        } else {
            Money.pesos(new BigDecimal(0))
        }
    }

}
