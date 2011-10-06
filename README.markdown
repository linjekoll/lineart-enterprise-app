# Linear-T Enteprise App for Linjekoll

## Structure

- lineart-enterprise-app - *umbrella project, contains meta info about modules*
  - lineart-enterprise-app-web
     - contains the web client and server
  - lineart-enterprise-app-assembly
     - contains no source code, only dependencies, _this is the project we run_
  - lineart-enterprise-app-ejb
     - business logic, db-interaction
     
## Setup
Needs a GlassFish datasource with jndi name jdbc/mysql. This can be created in Netbeans or via the GlassFish admin console.

A data source is approximately the same as a GlassFish JDBC Resource. A JDBC resource is tied to a JDBC Connection Pool. The connection pool represents the database and holds information like user credentials for the DB, maximum connections, timeouts and so on.

In the GlassFish console (usually http://localhost:4848) choose Resources -> JDBC -> JDBC Connection Pools.
