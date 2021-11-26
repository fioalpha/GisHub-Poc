package dependecies


object GistDependencies {
    val MAIN = listOf(
        ANDROIDX_CORE_KTS,
        ANDROIDX_APP_COMPAT,
        GOOGLE_MATERIAL,
        CONSTRAINT_LAYOUT,
        COROUTINE_ANDROID,
        RETROFIT,
        KOIN_ANDROID,
        KOIN_JVM,
        KOIN_COMPOSE,
        KOIN_NAVIGATION_GRAPH,
    )

    val UNIT_TEST = listOf(
        JUNIT,
        TRUTH,
        KOIN_TEST,
        KOIN_JVM,
        COROUTINE_ANDROID,
        COROUTINE_TEST,
        GSON,
        TEST_MOCK
    )

    val INTERFACE_TEST = listOf(
        ESPRESSO,
        TEST_EXT_JUNIT,
        KOIN_TEST
    )

}

