package dependecies

import org.gradle.api.artifacts.dsl.DependencyHandler

const val IMPLEMENTATION = "implementation"
const val TEST_IMPLEMENTATION = "testImplementation"
const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"


fun DependencyHandler.addDependency(dependencies: List<String>, type: String) {
    dependencies.forEach { add(type, it) }
}
