import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    private val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private val material = "com.google.android.material:material:${Versions.material}"

    private val junit = "junit:junit:${Versions.junit}"
    private val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    private val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    private val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    val uiLibraries = arrayListOf(appcompat, coreKtx, constraintLayout, material)
    val testLibraries = arrayListOf(junit)
    val androidTestLibraries = arrayListOf(androidxJunit, espresso)
    val navigationLibraries = arrayListOf(navigationFragment, navigationUi)

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