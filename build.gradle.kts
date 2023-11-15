// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    // Bu ikisini yeni ekledim,
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    // Bunu navigation yaparken birinden digerine veri gondermek icin ekliyoruz, yoksa hata veriyor.
    id("androidx.navigation.safeargs") version "2.6.0" apply false



}
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.7.4"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}