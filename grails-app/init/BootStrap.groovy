import com.dmc.domain.Menu
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        Environment.executeForCurrentEnvironment {

            development {

                new Menu(description: "Milanesa Napo").save(failOnError: true, flush: true)

            }

            production {

            }

            test {
                
            }


        }

    }
    def destroy = {
    }
}
