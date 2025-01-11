FROM maven:3-amazoncorretto-21
WORKDIR /app

# Копируем pom.xml и загружаем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код
COPY src ./src

# Указываем порт для приложения
EXPOSE 8083

# Запуск через mvn spring-boot:run для поддержки hot reload
ENTRYPOINT ["mvn", "spring-boot:run", "-Dspring.devtools.restart.enabled=true", "-Dspring-boot.run.arguments=--server.port=8083"]
