# Ktor Topics

## Server

Ktor supports following server engines:

- Netty
- Jetty
- Tomcat
- CIO (Coroutine-based I/O)
- ServletApplicationEngine

There are 2 types of server creations supported by Ktor. Both has difference of providing configurations.

1. **Embedded Server**:

This type of server takes the configuration while initializing server. So, whenever the configuration changes, we have
to recompile the code.

2. **EngineMain Server**:

This type of server has external configuration file(`application.conf`). Which doesn't require the recompilation on
configuration changes.