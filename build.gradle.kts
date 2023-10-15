buildscript {
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.androidApplication apply false
    id("com.android.library") version Versions.androidLibrary apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlinAndroid apply false
    id("com.google.dagger.hilt.android") version Versions.hilt apply false
}