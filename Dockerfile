# Sử dụng image Java base
FROM openjdk:21-jdk-slim

RUN mkdir -p /logs

WORKDIR /app

# Sao chép file JAR vào container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
# docker build -t myapp:v1 .
# docker run -d -p 8080:8080 --name myapp-container myapp:v1
# docker exec -it myapp-container /bin/bash
# exit

# docker logs myapp-container
# docker stop myapp-container
# docker rm myapp-container


