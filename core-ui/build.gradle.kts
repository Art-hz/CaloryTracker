plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("$rootDir/compose-module.gradle")
}
android {
    namespace = "com.plcoding.core_ui"

}

