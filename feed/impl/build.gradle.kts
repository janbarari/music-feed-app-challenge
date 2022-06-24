plugins {
    id("androidComposeLibrary")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
    kapt(libs.hilt.compiler)

    api(projects.common)
    api(projects.designSystem)
    api(projects.network)
    api(projects.feed.api)
}