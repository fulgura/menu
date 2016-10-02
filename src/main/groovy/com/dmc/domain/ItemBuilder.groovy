package com.dmc.domain

import com.dmc.domain.Item.Ranking
import com.dmc.valueobject.Money

/**
 * Builder pattern, using closures.
 *
 */
class ItemBuilder {

    /**
     * Item to build and fill properties
     */
    Item item

    Item build(Closure definition) {
        item = new Item()
        runClosure definition
        item
    }

    def name(String name) {
        item.name = name
    }

    def description(String description) {
        item.description = description
    }

    def price(Money price) {
        item.price = price
    }

    def ranking(Ranking ranking) {
        item.ranking = ranking
    }
    /**
     * Runs a closure using DELEGATE ONLY strategy
     * @param runClosure
     * @return
     */
    private runClosure(Closure runClosure) {
        Closure runClone = runClosure.clone()
        runClone.delegate = this
        runClone.resolveStrategy = Closure.DELEGATE_ONLY
        runClone()
    }

}