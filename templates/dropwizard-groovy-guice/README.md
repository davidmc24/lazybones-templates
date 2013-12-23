You have created a Dropwizard applicatin using Lazybones. The template created a basic build system using [Gradle][], configured to allow
both Java and [Groovy][] source files, as well as tests written using [Spock][]. Additionally, the template created basic infrastructure
for dependency injection using [Guice][].

To work with the project:

*   Add new source files to `src/main/groovy` or `src/main/java`.
*   Add new test files to `src/test/groovy`.
*   Check the quality of the application (including running tests) with `gradlew check`.
*   Run the application at development-time with `gradlew run` or `gradlew runDebug`.
*   Package the application with `gradlew build`.

[Gradle]: http://www.gradle.org/
[Groovy]: http://groovy.codehaus.org/
[Spock]: https://code.google.com/p/spock/
[Guice]: https://code.google.com/p/google-guice/
