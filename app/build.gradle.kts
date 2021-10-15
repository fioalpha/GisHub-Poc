import dependecies.ANDROID_TEST_IMPLEMENTATION
import dependecies.AppDependencies.INTERFACE_TEST
import dependecies.AppDependencies.MAIN
import dependecies.AppDependencies.UNIT_TEST
import dependecies.IMPLEMENTATION
import dependecies.TEST_IMPLEMENTATION
import dependecies.addDependency

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = dependecies.COMPILE_SDK

    defaultConfig {
        applicationId = dependecies.APPLICATION_ID
        minSdk = dependecies.MINIMUM_VERSION
        targetSdk = dependecies.TARGET_SDK
        versionCode = dependecies.VERSION_CODE
        versionName = dependecies.VERSION_NAME

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
    addDependency(MAIN, IMPLEMENTATION)
    addDependency(UNIT_TEST, TEST_IMPLEMENTATION)
    addDependency(INTERFACE_TEST, ANDROID_TEST_IMPLEMENTATION)
}