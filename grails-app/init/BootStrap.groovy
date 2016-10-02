import com.dmc.domain.Item
import com.dmc.domain.ItemBuilder
import com.dmc.domain.Menu
import com.dmc.valueobject.Money
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        Environment.executeForCurrentEnvironment {

            development {

                def milanesaNapo = new ItemBuilder().build {
                    name 'Milanesa Napo'
                    description 'Milanesa Napolitana'
                    price Money.pesos(new BigDecimal(100))
                    ranking Item.Ranking.FOUR
                }

                def menu = new Menu(description: "Milanesa Napo")
                menu.addToItems(milanesaNapo)
                menu.save(failOnError: true)
            }

            production {

            }

            test {
                grails.project.fork = false

            }


        }

    }
    def destroy = {
    }
}
