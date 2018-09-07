@file:Suppress("INACCESSIBLE_TYPE")

plugins {
    base

    kotlin("jvm") version "1.2.61" apply false

    id("com.diffplug.gradle.spotless") version "3.14.0"
    id("io.gitlab.arturbosch.detekt") version "1.0.0.RC7-3"
}

allprojects {

    group = "com.uqbar.kloudformation"

    version = "0.1"

    repositories {
        jcenter()
    }

}

subprojects {

    apply {
        plugin("com.diffplug.gradle.spotless")
    }

    spotless {

        kotlin {
            ktlint()

            licenseHeaderFile(rootProject.file("LICENSE"))
        }

        kotlinGradle {
            ktlint()

            licenseHeaderFile(rootProject.file("LICENSE"),
                    "(import |rootProject|dependencies|plugins|apply|include)")
        }

    }

}

dependencies {

    subprojects.forEach {
        archives(it)
    }

}