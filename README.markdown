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