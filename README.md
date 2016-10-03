# EXAMEN TÉCNICO 

1. Un menú cuenta con una lista de items (al menos 1), y una lista de submenús (en donde cada elemento de la lista es un menú, que puede estar vacía). Cada menú posee además una descripción y un flag que dice si este menú está activo o no.

Clases Menu e Item.

```groovy
class Menu extends Entity {

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

```

2. Un item de un menú cuenta con un nombre, una descripción, un precio con su respectiva moneda, una foto, los días que está disponible, fecha desde y hasta en el cual es válido, horario desde hasta en el cual aplica y un ranking de puntuación numérico que va desde el 1 al 5.

```groovy
class Item extends Entity {

    static final int MB = 1024 * 1024
    static final int MAX_PICTURE_SIZE = 100 * MB

    String name
    String description
    /**
     * Price of an item. His price is a Value Object from DDD perspective.
     */
    Money price
    /**
     * Item image. Rendering image value.
     */
    byte[] image
    /**
     *
     *
     */
//    Date validStarting
//    Date validEnding
//    Date availableAfter
//    Date availableBefore

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

    static embedded = ['price']

    /**
     * Validate entity fields.
     */
    static constraints = {
        name nullable: false
        description nullable: false
        price nullable: false
        image nullable: true, maxSize: MAX_PICTURE_SIZE
//        validStarting nullable: false
//        validEnding nullable: false
//        availableAfter nullable: false
//        availableBefore nullable: false
        ranking nullable: false
    }

    String toString() {
        "${name}. ${description} - price: ${price}"
    }

```


Por ejemplo, el ítem de menú “Milanesa napo” es válido de Viernes a Domingos de 20:00 hs. a 23:00 hs, desde el 1 de Marzo al 1 de Abril y tiene una puntuación de 5.

Nota:

No pude completar el trabajo de fechas. Me resta agregar la librería joda-time para poder usar DateTime y RangeTime en las entidades.


3. Un restaurante puede ofrecer diferentes menús, por ejemplo, “Menú del día” o “Menú de verano”.

```groovy


```




# 
![](https://github.com/fulgura/menu/blob/master/image.png)

# 
![](https://github.com/fulgura/menu/blob/master/Screen%20Shot%202016-10-03%20at%2012.29.46%20AM.png)

# 
![](https://github.com/fulgura/menu/blob/master/Screen%20Shot%202016-10-03%20at%2012.30.19%20AM.png)

# 
![](https://github.com/fulgura/menu/blob/master/Screen%20Shot%202016-10-03%20at%2012.31.04%20AM.png)


