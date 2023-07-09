plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Needle"
        }
    }

    sourceSets {
        /*
        Source sets structure
        common
         ├─ android
         ├─ ios
             ├─ iosX64
             ├─ iosArm64
             ├─ iosSimulatorArm64
         */
        val commonMain by getting {
            dependencies {
                //Network
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.kotlinx.json)
                implementation(libs.ktor.content.negotiation)
                //Coroutines
                implementation(libs.kotlinx.coroutines.core)
                //Logger
                implementation(libs.napier)
                //JSON
                implementation(libs.kotlinx.serialization.json)
                //Key-Value storage
                implementation(libs.multiplatform.settings)
                implementation(libs.multiplatform.settings.no.arg)
                // DI
                api(libs.koin.core)
            }
        }

        val androidMain by getting {
            dependencies {
                //Network
                implementation(libs.ktor.client.okhttp)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependencies {
                //Network
                implementation(libs.ktor.client.ios)
            }
        }
    }
}

android {
    namespace = "needle.devices.com"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled = true
    }
    dependencies {
        coreLibraryDesugaring(libs.desugar.jdk.libs)
    }
}
