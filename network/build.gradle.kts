plugins {
    id("androidLibrary")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)
    kapt(libs.hilt.compiler)

    api(libs.retrofit)
    api(libs.moshi.converter)
}