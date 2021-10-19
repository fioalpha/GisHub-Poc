import dependecies.addDependency

plugins {
    id("com.android.library")
    kotlin("android")
}

apply {
    from("../../quality/detekt.gradle")
    from("../../quality/jacoco.gradle")
}

android {
    compileSdk = dependecies.COMPILE_SDK

    defaultConfig {
        minSdk = dependecies.MINIMUM_VERSION
        targetSdk = dependecies.TARGET_SDK
        testInstrumentationRunner = dependecies.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    addDependency(dependecies.GistDependencies.MAIN, dependecies.IMPLEMENTATION)
    addDependency(dependecies.GistDependencies.UNIT_TEST, dependecies.TEST_IMPLEMENTATION)
    addDependency(
        dependecies.GistDependencies.INTERFACE_TEST,
        dependecies.ANDROID_TEST_IMPLEMENTATION
    )
}
