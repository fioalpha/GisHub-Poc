package dependecies


object GistDependencies {
    val MAIN = listOf(
        ANDROIDX_CORE_KTS,
        ANDROIDX_APP_COMPAT,
        GOOGLE_MATERIAL,
        CONSTRAINT_LAYOUT,
        COROUTINE_ANDROID,
        KOIN_ANDROID,
        KOIN_COMPOSE,
        KOIN_NAVIGATION_GRAPH
    )

    val UNIT_TEST = listOf(
        JUNIT
    )

    val INTERFACE_TEST = listOf(
        ESPRESSO,
        TEST_EXT_JUNIT,
    )
}

