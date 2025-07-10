import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

buildscript {
	configurations.all {
		resolutionStrategy {
			force("org.yaml:snakeyaml:1.33")
		}
	}
}

plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.3"
	id("org.openapi.generator") version "6.6.0"
}

group = "com.organizer"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Web & Security
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// Databases
	implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")

	// OpenAPI
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.3")

	// S3
	implementation("io.minio:minio:8.5.9")

	// Utils
	implementation("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")

	// Logging
	implementation("org.slf4j:slf4j-api:2.0.13")
	implementation("ch.qos.logback:logback-classic:1.4.14")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val openApiGenerate by tasks.getting(GenerateTask::class) {
	generatorName.set("spring")
	inputSpec.set("$projectDir/openapi.yml") // <--- убедись в названии файла!
	outputDir.set("$buildDir/generated")
	apiPackage.set("com.audiotour.api")
	modelPackage.set("com.audiotour.dto")

	configOptions.set(mapOf(
		"interfaceOnly" to "true",
		"useSpringBoot3" to "true",
		"useJakartaEe" to "true",
		"skipDefaultInterface" to "true"
	))
}

sourceSets.main {
	java.srcDir("$buildDir/generated/src/main/java")
}

tasks.withType<JavaCompile> {
	dependsOn(openApiGenerate)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

