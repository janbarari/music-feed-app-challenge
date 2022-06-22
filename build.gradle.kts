
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
    }

}


tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
