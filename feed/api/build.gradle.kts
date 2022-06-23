plugins {
    id("androidComposeLibrary")
    id("kotlin-parcelize")
}

dependencies {
    api(projects.navigation)
    api(projects.architecture)
    implementation(libs.moshi.converter)
}