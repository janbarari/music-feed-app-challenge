import com.android.build.gradle.LibraryExtension
import extension.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidComposeLibraryConventionLibrary : Plugin<Project> {

    @Suppress("UnstableApiUsage")
    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        project.plugins.apply("org.jetbrains.kotlin.android")

        project.dependencies.add(
            "testImplementation",
            project.versionCatalog().getDependency("test.junit")
        )
        project.dependencies.add(
            "androidTestImplementation",
            project.versionCatalog().getDependency("androidx.test.junit")
        )
        project.dependencies.add(
            "androidTestImplementation",
            project.versionCatalog().getDependency("androidx.test.espresso")
        )

        project.versionCatalog().getBundle("compose").forEach {
            project.dependencies.implementation(it)
        }

        project.versionCatalog().getBundle("android").forEach {
            project.dependencies.implementation(it)
        }

        project.dependencies.debugImplementation(project.versionCatalog().getDependency("compose-tool"))

        project.dependencies.debugImplementation(project.versionCatalog().getDependency("compose-test"))

        project.extensions.configure<LibraryExtension> {
            compileSdk = 32
            defaultConfig.targetSdk = 32
            defaultConfig.minSdk = 23

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }

            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = project.versionCatalog().getVersion("compose")
            }
        }

    }

}