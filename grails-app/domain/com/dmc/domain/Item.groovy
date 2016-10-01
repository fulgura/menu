package com.dmc.domain
/**
 *
 * Menu Item model. It reflects an item of a restaurant menu.
 *
 */
class Item extends Domain {

    static final int MB = 1024 * 1024
    static final int MAX_PICTURE_SIZE = 100 * MB

    String name
    String description


    BigDecimal price = BigDecimal.ZERO
    byte[] image

    /**
     *
     *
     */
    Date validStarting = new Date()
    Date validEnding = new Date()
    Date availableAfter
    Date availableBefore

    enum Ranking {

        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5)

        final Integer id

        private Ranking(Integer id) {
            this.id = id
        }

        static Ranking byId(Integer id) {
            values().find { it.id == id }
        }

        static Ranking lookup(Integer id) {
            for (Ranking type : values()) {
                if (type.equals(id)) return type
            }
            return null
        }
    }
    /**
     * Ranking of an item could be from 1 up to 5
     */
    Ranking ranking = Ranking.ONE

    static constraints = {
        name nullable: false
        description nullable: false
        price nullable: false
        image(nullable: true, maxSize: MAX_PICTURE_SIZE)
        validStarting nullable: false
        validEnding nullable: false
        availableAfter nullable: false
        availableBefore nullable: false
    }

    String toString() {
        "${name}. ${description} - price: ${price}"
    }
}
