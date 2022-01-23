import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "ru.maxdexter.myrecipes"
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 31
    val javaVersion = JavaVersion.VERSION_1_8
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val utils = ":utils"

    //Features
    const val homeScreen = ":homeScreen"
    const val favouriteScreen = ":favouriteScreen"
    const val randomScreen = ":randomScreen"
}

object Versions {
    const val kotlinStdlib = "1.5.21"
    const val coreKtx = "1.7.0"
    const val appcompat = "1.4.1"
    const val material = "1.5.0"
    const val constraintLayout = "2.1.3"
    const val legacySupport = "1.0.0"
    const val livedataKtx = "2.4.0"
    const val viewModelKtx = "2.4.0"
    const val testImplementationJunit = "4.13.2"
    const val androidTestImplementationJunit = "1.1.3"
    const val androidTestImplementationEspresso = "3.4.0"

    // Navigation Components
    const val navigationFragmentKtx = "2.3.5"
    const val navigationUiKtx = "2.3.5"
}

object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStdlib}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val support = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"

}

object Lifecycle {
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedataKtx}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
}

object Testing {
    const val jUnit = "junit:junit:${Versions.testImplementationJunit}"
    const val extJUnit =
        "androidx.test.ext:junit:${Versions.androidTestImplementationJunit}"
    const val espresso =
        "androidx.test.espresso:espresso-core:${Versions.androidTestImplementationEspresso}"
}

object Navigation {
    const val fragmentNavigation =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragmentKtx}"
    const val navigationUiNavigation =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationUiKtx}"
}



