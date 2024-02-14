plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
//    id("kotlin-android-extensions")
}

apply(from = "../shared_dependencies.gradle")

android {
    namespace = "com.rizfan.tourismapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rizfan.tourismapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    dynamicFeatures += setOf(":maps")
}

dependencies {
    implementation(project(":core"))
    implementation (fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    //RxJavaRoom
    implementation("androidx.room:room-rxjava2:2.6.1")


    // lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.6.2")


    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    //RXjava
    implementation("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

}