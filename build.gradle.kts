
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }

}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
