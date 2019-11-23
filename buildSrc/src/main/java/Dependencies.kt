private object Versions {
    const val androidGradlePlugin = "3.5.1"
    const val kotlin = "1.3.50"

    // androidx
    const val multidex = "2.0.1"
    const val androidxCore = "1.1.0"
    const val appCompat = "1.1.0"
    const val activity = "1.0.0"
    const val fragment = "1.2.0-rc02"
    const val constraintLayout = "1.1.3"
    const val recyclerView = "1.0.0"
    const val lifecycle = "2.1.0"

    const val rxjava = "2.2.10"
    const val rxkotlin = "2.4.0"
    const val rxandroid = "2.1.1"

    const val koin = "2.1.0-alpha-3"
    const val retrofit = "2.6.0"
    const val okhttp = "4.2.0"
    const val moshi = "1.8.0"

    // test
    const val junit = "1.1.1"
    const val mockk = "1.9.2.kotlin12"
    const val truth = "1.0"

    const val androidxCoreTesting = "2.1.0"

    // androidTest
    const val androidxTestRunner = "1.2.0"
    const val espresso = "3.2.0"

}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // androidx
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    const val koin = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinAndroidScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinAndroidFragment = "org.koin:koin-androidx-fragment:${Versions.koin}"
    const val koinAndroidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitAdapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
}

object TestLibraries {
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val truth = "com.google.truth:truth:${Versions.truth}"

    const val koin = "org.koin:koin-test:${Versions.koin}"

    const val androidxCore = "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}"

    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
}

object AndroidTestLibraries {
    const val androidxTestRunner = "androidx.test:runner:${Versions.androidxTestRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockk = "io.mockk:mockk-android:${Versions.mockk}"
}