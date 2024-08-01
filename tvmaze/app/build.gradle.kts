plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kp.tvmaze"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kp.tvmaze"
        minSdk = 24
        targetSdk = 34
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
    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }

    sourceSets{
        getByName("test") {
            java.srcDirs("src/test/java", "src/sharedTest/java")
        }
        getByName("androidTest") {
            java.srcDirs("src/androidTest/java", "src/sharedTest/java")
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Room Database
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    //hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    //coroutines
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")

    //Creating ViewModel
    val activity_version = "1.9.0"
    implementation("androidx.activity:activity-ktx:$activity_version")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.8")

    //Coroutines-Unitest
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

    //Mockito Unit test
    testImplementation("org.mockito:mockito-core:3.6.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    //In cases any issues in mocking the serailization
    //https://stackoverflow.com/questions/65647528/mockito-cannot-mock-this-class
    testImplementation("org.mockito:mockito-inline:5.2.0")

    testImplementation("androidx.arch.core:core-testing:2.2.0")

    //Retrofit unittesting
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
}