buildscript {
     repositories {
        google()
        mavenCentral()
        mavenLocal() // Add mavenLocal() repository here
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("maven-publish") // Add the maven-publish plugin here
    // << --- ADD This

}

android {
    namespace = "com.hexabyteds.easy_payment"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("consumer-rules.pro")       // << --- ADD This

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
          create<MavenPublication>("maven") {
            groupId = "com.github.Toqeer12" // Set your group ID
            artifactId = "easy-pamyent" // Set your artifact ID
            version = "1.0.0" // Set your version
            pom {
                description.set("DESCRIPTION")
            }
        }

    }
    repositories {
        mavenLocal()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation (libs.libphonenumber)

    implementation(libs.material)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}