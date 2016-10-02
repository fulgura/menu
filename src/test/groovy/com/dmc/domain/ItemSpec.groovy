package com.dmc.domain

import com.dmc.valueobject.Money
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test can make an Item using builder pattern"() {

        given:
        def item = new ItemBuilder().build {
            name 'Milanesa Napo'
            price Money.pesos(new BigDecimal(100))
            ranking Item.Ranking.FOUR
        }

        when:
        item.save(failOnError: true, flush: true)

        then:
        item.id

    }
}
