plugins {
    base
    kotlin("jvm") version "1.2.61" apply false
}

allprojects {

    group = "com.uqbar.kloudformation"

    version = "0.1"

    repositories {
        jcenter()
    }

}

dependencies {

    subprojects.forEach {
        archives(it)
    }

}
