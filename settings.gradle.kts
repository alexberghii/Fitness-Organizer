pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Fitness Organizer"
include(
    ":app",
    ":core",
    ":feature:reminders:api",
    ":feature:reminders:impl",
    ":domain:reminders:api",
    ":domain:reminders:impl",
    ":data:reminders",
    ":database"
)
