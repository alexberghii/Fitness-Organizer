import AppDependencies.implementation
import AppDependencies.testImplementation
import AppDependencies.androidTestImplementation

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.alexberghii.fitnessorganizer"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":feature:reminders:api"))
    implementation(project(":feature:reminders:impl"))
    implementation(project(":domain:reminders:api"))
    implementation(project(":domain:reminders:impl"))
    implementation(project(":data:reminders"))
    implementation(project(":database"))
    implementation(project(":navigation"))

    implementation(AppDependencies.uiLibraries)
    implementation(AppDependencies.navigationLibraries)
    implementation(AppDependencies.hilt)
    kapt(AppDependencies.hiltKapt)
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}

kapt {
    correctErrorTypes = true
}