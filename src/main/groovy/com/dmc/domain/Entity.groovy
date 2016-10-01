package com.dmc.domain

import groovy.transform.EqualsAndHashCode

/**
 * Abstract class definition. Necessary for using UUID in all domain classes
 *
 *  From DDD:
 *
 *  'An object that is not defined by its attributes, but rather by a thread of continuity and its identity.'
 */
@EqualsAndHashCode(includes = "id")
abstract class Entity implements Serializable {

    /**
     * Entity class indetificayion
     */
    String id

    Date dateCreated
    Date lastUpdated

    static mapping = {
        id generator: 'uuid2'
    }
}
