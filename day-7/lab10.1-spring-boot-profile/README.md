# Spring Profiles in Spring Boot Application

- Environment variable used to load a specific profile - `spring.profiles.active=dev`

# Hit these commands:
- package the application --> mvn clean package
- from ../target--> java -Dspring.profiles.active=dev -jar <jar name>, this start app and activate the dev 	profile

# use cURL: 
- curl http://localhost:9091/rest/hello --> wouln't work now as it will start the app as dev profile. 
- curl http://localhost:8081/rest/hello --> will work.  