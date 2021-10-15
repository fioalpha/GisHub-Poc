import dependecies.classPath

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {

            classpath("com.android.tools.build:gradle:${dependecies.TOOLS_BUILD}")
            classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${dependecies.KOTLIN_VERSION}")
//        }
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
