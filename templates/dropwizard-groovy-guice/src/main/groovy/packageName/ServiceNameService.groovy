package ${packageName}

import com.google.inject.Guice
import com.google.inject.Injector
import com.yammer.dropwizard.Service
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle
import com.yammer.dropwizard.migrations.MigrationsBundle

class ${serviceName}Service extends Service<${serviceName}Configuration> {

    public static final String APP_ID = "${serviceName}"

    public static void main(String[] args) throws Exception {
        new ${serviceName}Service().run(args)
    }

    @Override
    public void initialize(Bootstrap<${serviceName}Configuration> bootstrap) {
        bootstrap.name = APP_ID
    }

    @Override
    public void run(${serviceName}Configuration configuration, Environment environment) throws ClassNotFoundException {
        def injector = Guice.createInjector(
            new ${serviceName}Module(configuration)
        )
        // TODO: add resources, etc. from injector
    }

}
