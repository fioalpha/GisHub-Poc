import dependecies.addDependency

plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    addDependency(dependecies.RestClientDependencies.MAIN, dependecies.IMPLEMENTATION)
}