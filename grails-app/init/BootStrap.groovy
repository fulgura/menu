import com.dmc.service.Populator
import grails.util.Environment

class BootStrap {

    Populator populatorService

    def init = { servletContext ->

        Environment.executeForCurrentEnvironment {

            development {
                populatorService.populateInitialMenu()
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
