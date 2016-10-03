// Place your Spring DSL code here

import com.dmc.domain.DevPopulatorService
import grails.util.Environment

beans = {

    Environment.executeForCurrentEnvironment {
// Override bean definition in 'development' mode.
        development {
            populatorService(DevPopulatorService)
        }
    }

}
