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

apply {
    from("../quality/detekt.gradle")
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
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    addDependency(MAIN, IMPLEMENTATION)
    addDependency(UNIT_TEST, TEST_IMPLEMENTATION)
    addDependency(INTERFACE_TEST, ANDROID_TEST_IMPLEMENTATION)
}
