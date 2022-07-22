@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
	alias(libs.plugins.android.gradle.app) apply false
	alias(libs.plugins.android.gradle.lib) apply false
	alias(libs.plugins.kotlin.android) apply false
	alias(libs.plugins.ben.manes.versions)
	alias(libs.plugins.detekt)
}

val detektFormatting = libs.detekt.formatting
subprojects {
	apply {
		plugin("io.gitlab.arturbosch.detekt")
	}

	detekt {
		config = rootProject.files("config/detekt/detekt.yml")
	}

	dependencies {
		detektPlugins(detektFormatting)
	}
}
