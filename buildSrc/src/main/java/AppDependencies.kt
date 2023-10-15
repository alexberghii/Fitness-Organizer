import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    private val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    private val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    private val room = "androidx.room:room-runtime:${Versions.room}"
    private val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomKapt = "androidx.room:room-compiler:${Versions.room}"

    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    private val junit = "junit:junit:${Versions.junit}"
    private val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    private val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val uiLibraries = arrayListOf(appcompat, coreKtx, constraintLayout, material, fragmentKtx)
    val navigationLibraries = arrayListOf(navigationFragment, navigationUi)
    val roomLibraries = arrayListOf(room, roomKtx)
    val testLibraries = arrayListOf(junit)
    val androidTestLibraries = arrayListOf(androidxJunit, espresso)

    fun DependencyHandler.kapt(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.api(list: List<String>) {
        list.forEach { dependency ->
            add("api", dependency)
        }
    }

    fun DependencyHandler.testImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }

    fun DependencyHandler.androidTestImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("androidTestImplementation", dependency)
        }
    }
}