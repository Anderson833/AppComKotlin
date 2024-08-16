plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
   // id("kotlin-kapt")
}


android {
    namespace = "com.financ.finances"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.financ.finances"
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
   viewBinding {
       enable=true;
   }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-common-ktx:21.0.0") /// aqui foi importado digitando o nome e autoComplete
    testImplementation("junit:junit:4.13.2")
    implementation(platform("com.google.firebase:firebase-bom:33.1.2")) // aqui foi pegado da web
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    implementation("com.google.firebase:firebase-auth-ktx")// aqui foi trazido da web na pagina de painel de autenticação
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.google.firebase:firebase-firestore-ktx") /// pegando da web cloud firestore
   // implementation("android.arch.lifecycle:extensions:1.1.1")
   // kapt("android.arch.lifecycle:compiler:1.1.1")

}