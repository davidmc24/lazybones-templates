package ${packageName}

import com.google.inject.Guice
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment

/**
 * Entry-point service for the application.
 */
class ${serviceName}Service extends Service<${serviceName}Configuration> {

    public static final String APP_ID = "${serviceName}"

    static void main(String[] args) throws Exception {
        new ${serviceName}Service().run(args)
    }

    @Override
    void initialize(Bootstrap<${serviceName}Configuration> bootstrap) {
        bootstrap.name = APP_ID
    }

    @Override
    void run(${serviceName}Configuration configuration, Environment environment) throws ClassNotFoundException {
        def injector = Guice.createInjector(
            new ${serviceName}Module(configuration)
        )
        // TODO: add resources, etc. from injector
        // TODO: use multibindings?  https://code.google.com/p/google-guice/wiki/Multibindings
    }

}
