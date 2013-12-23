def filterProperties = [:]
filterProperties.group = ask("Define value for 'group': ")
filterProperties.version = ask("Define value for 'version' [0.1.0]: ", "0.1.0")

filterProperties.packageName = ask("Define value for package structure [app]: ", "app")
filterProperties.serviceName = ask("Define value for the name of the service [Main]: ", "Main")

filterFiles("gradle.properties", filterProperties)
filterFiles("build.gradle", filterProperties)
filterFiles("src/main/groovy/packageName/ServiceNameConfiguration.groovy", filterProperties)
filterFiles("src/main/groovy/packageName/ServiceNameService.groovy", filterProperties)
filterFiles("src/main/groovy/packageName/ServiceNameModule.groovy", filterProperties)

// move to user specified directory structure
def packageDirectoryStructure = filterProperties.packageName.replace('.', '/')
new AntBuilder().move( todir: "${targetDir}/src/main/groovy/${packageDirectoryStructure}") {
    fileset( dir:"${targetDir}/src/main/groovy/packageName" )
}

// move to user specified service name
def configurationFile = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/ServiceNameConfiguration.groovy")
configurationFile.renameTo("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Configuration.groovy")

def serviceFile = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/ServiceNameService.groovy")
serviceFile.renameTo("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Service.groovy")

def moduleFile = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/ServiceNameModule.groovy")
moduleFile.renameTo("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Module.groovy")
