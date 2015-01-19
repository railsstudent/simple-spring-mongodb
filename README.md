# simple-spring-mongodb

0. Need to install Java 7+ 
1. Install MongoDB (https://www.mongodb.org/downloads)
  * Add mongo/bin folder to PATH variable
2. Install Maven 3.2.5  (http://maven.apache.org/download.cgi)
  * Add maven/bin folder to PATH variable
3. Read README file of MongoDB and create /data/db directory accordingly
4. Run mongodb in command line in local computer 
  *   ./mongod    
5.  Open another command console to start mongo 
  * ./mongo
  * Create mydb database in mongo console
    * use mydb
    * create documents in people collection
      * db.people.insert({ firstname : 'Peter', lastname : 'Chan', gender: 'MALE'})
      * db.people.insert({ firstname : 'Jane', lastname : 'Chan', gender: 'FEMALE'})
      * db.people.insert({ firstname : 'Joyce', lastname : 'Chan', gender: 'FEMALE'})
5.  Open another command console to start spring boot application\
  * mvn spring-boot:run
6.  Open browser to test the project
  * Type http://localhost/app/rest/persons/all in address bar and three records are shown as result
