import ratpack.groovy.template.TextTemplateModule

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
	bindings {
		module new TextTemplateModule()
	}

	handlers {

		def title = 'Our Ratpack Playground'
		get {
			render 'Hello, World!'
		}

		get(':name') {
			render( groovyTemplate( 'index.html', title: title, message: "Hello, $pathTokens.name!" ))
		}

		prefix( 'dummy') {
			get(':name') {
				render "Hello dummy, $pathTokens.name!"
			}
		}
	}
}
