plugins {
    id("androidComposeLibrary")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(projects.common)
    api(projects.feed.api)
    api(projects.architecture)
    api(projects.navigation)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    implementation(projects.designSystem)

    implementation(libs.retrofit)
    implementation(libs.moshi.converter)
}