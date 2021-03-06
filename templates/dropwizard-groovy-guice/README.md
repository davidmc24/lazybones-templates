You have created a [Dropwizard][] application using Lazybones. The template created a basic build system using [Gradle][], configured to
allow both Java and [Groovy][] source files, tests written using [Spock][], and static code analysis using [Codenarc][]. Additionally, the
template created basic infrastructure for dependency injection using [Guice][].

To work with the project:

*   Add new source files to `src/main/groovy` or `src/main/java`.
    *   Resources/HealthChecks/Providers/Tasks/Managed will be automatically injected and registered with Dropwizard.
*   Add new test files to `src/test/groovy`.
*   Check the quality of the application (including running tests) with `gradlew check`.
    *   Tweak Codenarc rules as needed in `config/codenarc/codenarc.groovy`
*   Run the application at development-time with `gradlew run` or `gradlew runDebug`.
    *   This will use the configuration file in `config/dev.yaml`.
*   Package the application with `gradlew build`.

[Dropwizard]: http://www.dropwizard.io/
[Gradle]: http://www.gradle.org/
[Groovy]: http://groovy.codehaus.org/
[Spock]: https://code.google.com/p/spock/
[Guice]: https://code.google.com/p/google-guice/
[CodeNarc]: http://codenarc.sourceforge.net/
