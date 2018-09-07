plugins {
    jacoco
    kotlin("jvm")

    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    compile(kotlin("stdlib"))
}

jacoco {
    toolVersion = "0.8.2"
}

val jacocoTestCoverageVerification by tasks.getting(JacocoCoverageVerification::class) {
    violationRules {
        rule {
            limit {
                minimum = BigDecimal.valueOf(0.8)
            }
        }
    }

    val check by tasks
    check.dependsOn(this)
}

detekt {
    version = "1.0.0.RC7-3"

    profile("main", Action {
        input = "$projectDir/src/main/kotlin"
        config = "$projectDir/detekt.yml"
        filters = ".*test.*,.*/resources/.*,.*/tmp/.*"
    })
}