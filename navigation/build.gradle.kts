plugins {
    id("androidComposeLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
    kapt(libs.hilt.compiler)

    implementation(projects.common)
    api(projects.architecture)
}