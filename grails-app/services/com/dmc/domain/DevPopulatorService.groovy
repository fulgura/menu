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
        }.save(failOnError: true))
        menu.save(failOnError: true)

        def menuCaldoGallego = new Menu(description: "Caldo Gallego")
        def subMenu1 = new Menu(description: "SubMenu 1").save(failOnError: true)
        menuCaldoGallego.addToSubMenus(subMenu1)

        menuCaldoGallego.addToItems(new ItemBuilder().build {
            name 'Item 1'
            description 'Description Item 1'
            price Money.pesos(new BigDecimal(100))
            ranking Item.Ranking.THREE
        }.save(failOnError: true))
        menuCaldoGallego.addToItems(new ItemBuilder().build {
            name 'Item 2'
            description 'Description Item 2'
            price Money.pesos(new BigDecimal(200))
            ranking Item.Ranking.THREE
        }.save(failOnError: true))
        menuCaldoGallego.addToItems(new ItemBuilder().build {
            name 'Item 8'
            description 'Description Item 8'
            price Money.pesos(new BigDecimal(200))
            ranking Item.Ranking.THREE
        }.save(failOnError: true))
        def subMenu2 = new Menu(description: "SubMenu 2").save(failOnError: true)
        menuCaldoGallego.addToSubMenus(subMenu2)
        menuCaldoGallego.save(failOnError: true)

        def menuCanelonAtun = new Menu(description: "Canelon de Atun")
        menuCanelonAtun.addToItems(new ItemBuilder().build {
            name 'Item 3'
            description 'Description Item 3'
            price Money.pesos(new BigDecimal(300))
            ranking Item.Ranking.THREE
        }.save(failOnError: true))
        menuCanelonAtun.addToItems(new ItemBuilder().build {
            name 'Item 4'
            description 'Description Item 4'
            price Money.pesos(new BigDecimal(300))
            ranking Item.Ranking.THREE
        }.save(failOnError: true))
        menuCanelonAtun.addToItems(new ItemBuilder().build {
            name 'Item 5'
            description 'Description Item 5'
            price Money.pesos(new BigDecimal(100))
            ranking Item.Ranking.THREE
        }.save(failOnError: true))
        menuCanelonAtun.addToSubMenus(menuCaldoGallego)
        menuCanelonAtun.save(failOnError: true)


    }
}
