# Sử dụng image Java base
FROM openjdk:21-jdk-slim
# Đặt thư mục làm việc
WORKDIR /app

# Sao chép file JAR vào container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
