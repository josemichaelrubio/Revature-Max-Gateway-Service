FROM java:8
COPY build/libs/GatewayService-1.0.jar .
EXPOSE 9990
CMD java -jar GatewayService-1.0.jar