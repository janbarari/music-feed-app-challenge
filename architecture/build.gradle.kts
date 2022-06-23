plugins {
    id("androidComposeLibrary")
}

dependencies {
    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(libs.coroutine)
    implementation(libs.accompanist.navigation)
}
