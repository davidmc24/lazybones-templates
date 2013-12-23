package ${packageName}

import com.google.inject.AbstractModule

class ${serviceName}Module extends AbstractModule {

    private final ${serviceName}Configuration configuration

    ${serviceName}Module(${serviceName}Configuration configuration) {
        this.configuration = configuration
    }

    @Override
    protected void configure() {
        // Bind additional services here, or below in @Provides methods
    }

}
