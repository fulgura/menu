package com.dmc.domain

import org.springframework.http.HttpStatus

class MenuAPIController extends APIBaseController {

    /**
     *
     * Listing all menus.
     *
     * @return
     */
    def list(ListMenuCommand command) {
        bindData(command, params)
        dispatch(command, HttpStatus.OK)
    }
    /**
     *
     * List all items for a menu ordering by String content. Default order is by price
     *
     * @param menu
     * @param order
     */

    def read(ReadMenuCommand command) {
        bindData(command, params)
        dispatch(command, HttpStatus.OK)
    }
}
/**
 *
 *
 */
class ListMenuCommand {

    def execute() {
        Menu.list()
    }
}
/**
 *
 *
 */
class ReadMenuCommand {

    String id
    Menu menu
    /**  For future releases that can group by other fields */
    String group = 'price'

    static constraints = {
        id nullable: false, validator: { val, command ->
            command.menu = Menu.get(val)
            if (!command.menu) {
                command.errors.rejectValue('menu', 'unknown.menu')
                return ['unknown.menu']
            }
        }
        group nullable: false
        menu nullable: true
    }

    def execute() {
        [
                description: menu.description,
                enable     : menu.enabled,
                items      : menu.items.groupBy({ Item item -> item.price }).collect {
                    [
                            price : [
                                    amount : it.key.amount,
                                    curency: it.key.currency
                            ],
                            values: it.value.collect { Item item -> [name: item.name, description: item.description] }
                    ]
                },
                subMenus   : menu.subMenus

        ]
    }
}
