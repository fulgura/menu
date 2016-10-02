class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/api/menus"(controller: 'menuAPI') {
            action = [GET: "apiIndex"]
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')


    }
}
