import dependecies.classPath

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${dependecies.TOOLS_BUILD}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${dependecies.KOTLIN_VERSION}")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.1")
        classpath("org.jacoco:org.jacoco.core:0.8.7")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
