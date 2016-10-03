package com.dmc.domain

import com.dmc.service.Populator
import com.dmc.valueobject.Money
import grails.transaction.Transactional

@Transactional
class DevPopulatorService implements Populator {

    /**
     *
     * Initial population. Creates all necessary data for menus and items that system needs.
     *
     * @return
     */
    @Override
    def populateInitialMenu() {

        def menu = new Menu(description: "Milanesa Napo")
        menu.addToItems(new ItemBuilder().build {
            name 'Milanesa Napo'
            description 'Milanesa Napolitana'
            price Money.pesos(new BigDecimal(100))
            ranking Item.Ranking.FOUR
        })
        menu.save(failOnError: true)


        def menuCaldoGallego = new Menu(description: "Caldo Gallego")
        menuCaldoGallego.addToItems(new ItemBuilder().build {
            name 'Item 1'
            description 'Description Item 1'
            price Money.pesos(new BigDecimal(100))
            ranking Item.Ranking.THREE
        })
        menuCaldoGallego.save(failOnError: true)

        def menuCanelonAtun = new Menu(description: "Canelon de Atun")
        menuCaldoGallego.addToItems(new ItemBuilder().build {
            name 'Item 2'
            description 'Description Item 2'
            price Money.pesos(new BigDecimal(200))
            ranking Item.Ranking.THREE
        })
        menuCaldoGallego.save(failOnError: true)

    }
}
