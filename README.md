# springboot-cassandra-reactive
Cassandra DB reactive programming with Spring Boot and Docker Compose

Find the running Container:
docker ps

Get into bash mode: 
docker exec -it <container-id> bash

Run below command to enter into CQL sh mode:
cqlsh

To see the existing keyspaces:
describe keyspaces

Create the required KeySpace:
CREATE KEYSPACE mykeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

To see the updated KeySpaces: 
describe keyspaces

Using the created KeySpace:
use mykeyspace;

Create the table:
CREATE TABLE user( id int PRIMARY KEY, name text, address text, age int);

Validate Records:
select * from user;