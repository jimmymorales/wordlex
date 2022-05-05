@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.android.gradle.app) apply false
    alias(libs.plugins.android.gradle.lib) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.ben.manes.versions)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ktlint)
}

val ktlintVersion = libs.versions.ktlint.get()
subprojects {
    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
    }

    ktlint {
        debug.set(false)
        version.set(ktlintVersion)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}
