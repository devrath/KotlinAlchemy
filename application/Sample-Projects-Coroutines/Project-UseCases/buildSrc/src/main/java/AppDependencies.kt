import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val coreTesting = "androidx.arch.core:core-testing:${Versions.version_core_testing}"
    private const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.version_coroutines}"
    private const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.version_retrofit_mock}"

    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    private const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.version_coroutines}"
    private const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.version_coroutines}"
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.version_appcompat}"
    private const val material = "com.google.android.material:material:${Versions.version_google_material}"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.version_constraint_layout}"
    private const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.version_recyclerview}"
    private const val cardView = "androidx.cardview:cardview:${Versions.version_card_view}"
    private const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.version_lifecycle}"
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.version_retrofit}"
    private const val rxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.version_adapter_rxjava2}"
    private const val gson = "com.google.code.gson:gson:${Versions.version_gson}"
    private const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.version_converter_gson}"
    private const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.version_rx_android}"
    private const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.version_rxjava}"
    private const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.version_rxkotlin}"
    private const val workRuntime = "androidx.work:work-runtime:${Versions.version_work_manager}"
    private const val timber = "com.jakewharton.timber:timber:${Versions.version_timber}"
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.version_room}"
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.version_room}"
    private const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.version_dagger}"
    private const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.version_dagger}"


    private const val coreKtx = "androidx.core:core-ktx:${Versions.version_ktx_core}"
    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.version_ktx_activity}"
    private const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx${Versions.version_lifecycle}"
    private const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.version_lifecycle}"


    private const val liveDataCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.version_lifecycle}"
    private const val workRuntimeKtx = "androidx.work:work-runtime-ktx:${Versions.version_work_manager}"
    private const val roomKtx = "androidx.room:room-ktx:${Versions.version_room}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coroutinesCore)
        add(coroutinesAndroid)
        add(appcompat)
        add(material)
        add(constraintLayout)
        add(recyclerView)
        add(cardView)
        add(commonJava8)
        add(retrofit)
        add(rxJava2)
        add(gson)
        add(converterGson)
        add(rxAndroid)
        add(rxJava)
        add(rxKotlin)
        add(workRuntime)
        add(timber)
        add(roomRuntime)
        add(hiltAndroid)
        add(viewModelKtx)
        add(liveDataKtx)
        add(coreKtx)
        add(roomKtx)
        add(activityKtx)
        add(workRuntimeKtx)
    }

    val appLibrariesKtx = arrayListOf<String>().apply {
        add(liveDataCompiler)
        add(roomCompiler)
        add(hiltCompiler)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(coreTesting)
        add(coroutinesTest)
        add(retrofitMock)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency -> add("kapt", dependency) }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency -> add("implementation", dependency) }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency -> add("androidTestImplementation", dependency) }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency -> add("testImplementation", dependency) }
}