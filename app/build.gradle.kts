plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.android") version "1.7.10" // Agrega el plugin de Kotlin
}

android {
    namespace = "com.example.traducir"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.traducir"
        minSdk = 29
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures { viewBinding = true }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10") // Asegúrate de tener la biblioteca estándar de Kotlin
}
