import java.nio.file.Files
import java.nio.file.FileVisitResult
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.StandardCopyOption
import java.nio.file.attribute.BasicFileAttributes
import java.util.regex.Matcher

def filterProperties = [:]
filterProperties.group = ask("What is the group ID for this project? (optional) ", null, "group")
filterProperties.version = ask("What is the project's initial version? [0.1.0] ", "0.1.0", "version")
filterProperties.packageName = ask("What is the main package for the project? [app] ", "app", "packageName")
filterProperties.serviceName = ask("What is the main service for the project? [Main] ", "Main", "serviceName")

// move template files to user specified package and name
def packageDirectoryStructure = filterProperties.packageName.replace(".", "/")
def templatePath = Paths.get("${targetDir}/src/main/groovy/packageName")
def groovyPackagePath = Paths.get("${targetDir}/src/main/groovy/${packageDirectoryStructure}")
Files.createDirectories(groovyPackagePath)
Files.walkFileTree(templatePath, new SimpleFileVisitor<Path>() {
    FileVisitResult visitFile(Path sourceFile, BasicFileAttributes attrs) {
        def targetName = sourceFile.fileName.toString().replace("ServiceName", Matcher.quoteReplacement(filterProperties.serviceName))
        def targetFile = groovyPackagePath.resolve(targetName)
        Files.move(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING)
        return FileVisitResult.CONTINUE
    }
})
Files.delete(templatePath)

processTemplates("gradle.properties", filterProperties)
processTemplates("src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Configuration.groovy", filterProperties)
processTemplates("src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Service.groovy", filterProperties)
processTemplates("src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Module.groovy", filterProperties)
