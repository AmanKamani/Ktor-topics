# Ktor Topics

## Auto Reloading

1. Embedded Server Auto Reloading

- Add watchPaths argument in embeddedServer function

2. EngineMain Auto Reloading

- Enable Development mode in configuration file
  `development = true`
- Add watch paths in configuration file
  `watch = [ classes, resources]`

> `Note:`
> watch/watchPaths will contain the folder names of build folder

Required for both the methods:

- Add below line into **gradle.properties** (Optional: If JAVA_HOME variable not set)
  `org.gradle.java.home=path_to_jdk_without_bin`
- Build project with:

> ./gradlew -t build \
`-t :` will watch for the file changes & rebuild the project
