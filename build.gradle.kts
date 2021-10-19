import dependecies.classPath

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${dependecies.TOOLS_BUILD}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${dependecies.KOTLIN_VERSION}")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.1")
        classpath("org.jacoco:org.jacoco.core:0.8.7")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.1.0")
    }
}

apply(from="./quality/KtlintXmlParse.gradle")

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    apply(plugin="org.jlleitschuh.gradle.ktlint")

    repositories {
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
        verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true)
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }
    }
}



