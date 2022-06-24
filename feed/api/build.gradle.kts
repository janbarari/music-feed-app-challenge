plugins {
    id("androidComposeLibrary")
    id("kotlin-parcelize")
}

dependencies {
    api(projects.navigation)
    implementation(libs.moshi.converter)
}