package com.dmc.domain

import groovy.transform.EqualsAndHashCode

/**
 * Abstract class definition. Necessary for using UUID in all domain classes
 *
 *
 */
@EqualsAndHashCode(includes = "id")
abstract class Domain implements Serializable {

    /**
     * Domain class indetificayion
     */
    String id

    Date dateCreated
    Date lastUpdated

    static mapping = {
        id generator: 'uuid2'
    }
}
