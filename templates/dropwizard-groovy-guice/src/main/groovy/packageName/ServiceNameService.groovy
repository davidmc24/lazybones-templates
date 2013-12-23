package ${packageName}

import com.fiestacabin.dropwizard.guice.AutoConfigService
import com.google.inject.Guice
import com.google.inject.Injector
import com.yammer.dropwizard.config.Bootstrap

/**
 * Entry-point service for the application.
 */
class ${serviceName}Service extends AutoConfigService<${serviceName}Configuration> {

    public static final String APP_ID = "${serviceName}"

    static void main(String[] args) throws Exception {
        new ${serviceName}Service().run(args)
    }

    @Override
    void initialize(Bootstrap<${serviceName}Configuration> bootstrap) {
        // dropwizard-guice provides a constructor which would eliminate the need for this.
        // However, the current version doesn't seem to initialize Reflections properly in that case.
        bootstrap.name = APP_ID
    }

    @Override
    protected Injector createInjector(${serviceName}Configuration configuration) {
        Guice.createInjector(
            new ${serviceName}Module(configuration)
        )
    }

}
