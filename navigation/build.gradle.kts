plugins {
    id("androidComposeLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    implementation(libs.accompanist.navigation)
}