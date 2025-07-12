# Этап 1: Собираем приложение с помощью Gradle
FROM gradle:8.4-jdk17 AS build
WORKDIR /app

# Копируем только файлы сборки для кэширования зависимостей
COPY build.gradle.kts ./
COPY gradle ./gradle
COPY gradlew ./
RUN chmod +x ./gradlew

# Загружаем зависимости, этот слой будет кэшироваться, если файлы сборки не менялись
RUN ./gradlew dependencies

# Копируем остальной исходный код и openapi.yml
COPY src ./src
COPY openapi.yml ./

# Собираем приложение, пропуская тесты
RUN ./gradlew bootJar --no-daemon

# Этап 2: Собираем сам образ
FROM eclipse-temurin:17-jre-focal
WORKDIR /app

# Копируем собранный JAR-файл из сборочного стейджа
COPY --from=build /app/build/libs/*.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
