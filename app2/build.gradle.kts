plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 34
    namespace = "androidx.test.experiments.app"

    defaultConfig {
        applicationId = "androidx.test.experiments.app2"
        minSdk = 24
        targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
        release {
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    lint {
        abortOnError = true
    }
}

dependencies {
    // NOTE 1: The presence of version "1.5.5" of the "fragment-testing" library as an implementation((i.e. non-test) dependency causes the "connectedDebugAndroidTest" Gradle task to hang indefinitely)
    // NOTE 2: The "fragment-testing" library exists as an implementation((i.e. non-test) dependency because that is a requirement of the library. See the following issue for more information: https:)//issuetracker.google.com/issues/128612536
    // NOTE 3: Comment out the "fragment-testing" dependency below or upgrade it to version "1.6.0" and run the "connectedDebugAndroidTest" Gradle task again. You will see that it runs to completion perfectly fine.
    debugImplementation("androidx.fragment:fragment-testing:1.5.5")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}
