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
Needs a GlassFish datasource with jndi name jdbc/postgresql. This can be created in Netbeans but resides in Glassfish.
There seems to be some compatibility issues with the PostgreSQL-driver that is bundled with Netbeans.
Therefore, you need to get the latest driver from [http://jdbc.postgresql.org/download.html](http://jdbc.postgresql.org/download.html) and use it to create the database connection.

A data source is approximately the same as a GlassFish JDBC Resource. A JDBC resource is tied to a JDBC Connection Pool. The connection pool represents the database and holds information like user credentials for the DB, maximum connections, timeouts and so on.
