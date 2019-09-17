Configuration to do:

Hystrix dashboard:  http://localhost:8080/hystrix

info about app: http://localhost:8080/info

service url: http://localhost:8080/getSchoolDetails/Hindustan College

Note: enabled via annotating a @Configuration with @EnableHystrixDashboard

################################

add http://localhost:8080/hystrix.stream, in dashboard to get a meaningful dynamic visual 
representation of the circuit being monitored by the Hystrix component.

################################