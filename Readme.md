# GraphQL + Spring Boot
Spring Boot 2.0.0 Tutorial 

![](https://img.shields.io/badge/Java-8-orange.svg?logo=java)
![](https://img.shields.io/badge/Spring%20Boot-2.1.2-green.svg)
![](https://img.shields.io/badge/GraphQL-4.0.0-E0008B.svg?logo=GraphQL)
![](https://img.shields.io/badge/Gradle-4.10.3-002A32.svg)

## Project Structure

- [*.graphqls](src/main/resources/petshop.graphqls) related with [resolvers](src/main/java/th/in/lordgift/graphql_spring_boot_tutorial/resolvers)
- Presentation layer, Business layer, Persistence layer conform to https://github.com/lordgift/SpringBoot2Tutorial


## How To Play


every services depend on [*.graphqls](src/main/resources/petshop.graphqls) by `POST` to http://localhost:8080/spring/graphql


##### Tool for Test GraphQL 

- [GraphQL Playground](https://github.com/prisma/graphql-playground)
- [Postman](https://www.getpostman.com/) *select GraphQL in Body Tab


-----------

Request payload (difference from JSON), Copy and paste the below there:

    {
        pets {
            name
            age
            type
        }
    }

Response:

    {
        "data": {
            "pets": [
                {
                    "name": "Bill",
                    "age": 9,
                    "type": "MAMMOTH"
                }
            ]
        }
    }

Congratulations!