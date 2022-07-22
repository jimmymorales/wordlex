@file:Suppress("UnstableApiUsage")

plugins {
	id("com.android.application")
	kotlin("android")
}

android {
	val appId = "dev.jimmymorales.wordlex"
	namespace = appId
	compileSdk = libs.versions.sdk.compile.get().toInt()

	defaultConfig {
		minSdk = libs.versions.sdk.min.get().toInt()
		targetSdk = libs.versions.sdk.target.get().toInt()

		applicationId = appId
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_11.toString()
		allWarningsAsErrors = true
		freeCompilerArgs = freeCompilerArgs + listOf(
			"-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
		)
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
	}
	packagingOptions {
		resources {
			excludes += setOf(
				"/META-INF/{AL2.0,LGPL2.1}",
				"DebugProbesKt.bin"
			)
		}
	}
	lint {
		warningsAsErrors = true
		abortOnError = true
	}
}

dependencies {
	implementation(libs.androidx.activity.compose)
	implementation(libs.androidx.core)
	implementation(libs.androidx.lifecycle)
	implementation(libs.androidx.lifecycle.compose)

	implementation(libs.bundles.compose.ui)
	debugImplementation(libs.bundles.compose.ui.debug)
	androidTestImplementation(libs.androidx.compose.ui.test.junit4)

	implementation(libs.kotlinx.coroutines)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.junit4)
	androidTestImplementation(libs.androidx.test.espresso)
}
