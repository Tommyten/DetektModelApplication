import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    id("es.horm.easyadldetektplugin.gradleplugin") version "0.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(kotlin("test"))
    detektPlugins("es.horm.easyadldetektplugin:easyAdlDetektPlugin:0.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

easyAdl {
    archDescriptionPath = "E:\\IdeaProjects\\DetektPluginTest\\archDescription.eadl"
}

detekt {
    toolVersion = "1.22.0"
    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
}

tasks {
    withType<io.gitlab.arturbosch.detekt.Detekt> {
        reports {
            custom {
                reportId = "ArchReport"
                // This tells detekt, where it should write the report to,
                // you have to specify this file in the gitlab pipeline config.
                outputLocation.set(file("$buildDir/reports/easyAdl/archReport.html"))
            }
        }
    }
}
