buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://objectbox.io/repo/") }
    }
    dependencies {
        classpath("io.objectbox:objectbox-gradle-plugin:3.8.0")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}
