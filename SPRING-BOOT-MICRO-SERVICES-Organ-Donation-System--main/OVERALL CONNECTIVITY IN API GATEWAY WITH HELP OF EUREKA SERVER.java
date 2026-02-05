spring.application.name=api-gateway-service
server.port =8000

#eureka configuration 
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
spring.cloud.gateway.discovery.locator.enabled=false
spring.cloud.netflix.eureka.discovery.enabled=true

#static route for donor-service
spring.cloud.gateway.routes[0].id=donor-service
spring.cloud.gateway.routes[0].uri=lb://DONOR-SERVICE
spring.cloud.gateway.routes[0].predicates[0]=Path=/donors/**

#static route for recipient-dervice 
spring.cloud.gateway.routes[1].id=recipient-service
spring.cloud.gateway.routes[1].uri=lb://RECIPIENT-SERVICE
spring.cloud.gateway.routes[1].predicates[0]=Path=/recipients/**


#static route for doctor-service
spring.cloud.gateway.routes[2].id=doctor-service
spring.cloud.gateway.routes[2].uri=lb://DOCTOR-SERVICE
spring.cloud.gateway.routes[2].predicates[0]=Path=/doctors/**
