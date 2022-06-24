plugins {
    id("androidComposeLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
    kapt(libs.hilt.compiler)

    implementation(libs.accompanist.navigation)
    implementation(projects.architecture)
    implementation(projects.common)
}