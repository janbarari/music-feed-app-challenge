plugins {
    id("androidComposeLibrary")
}

dependencies {
    implementation(libs.coroutine)
    api(libs.accompanist.navigation)
}
