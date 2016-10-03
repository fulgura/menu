class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/api/menus"(controller: 'menuAPI') {
            action = [GET: "list"]
        }

        "/api/menus/$id"(controller: 'menuAPI') {
            action = [GET: "read"]
        }
        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')


    }
}
