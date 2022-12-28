
import AppDependencies.firebaseAnnotation
import AppDependencies.hiltCoroutinesAnnotation

plugins {
    app()
    compose()
}

dependencies {
    implementation(project(":modules:presentation"))

    implementation(AppDependencies.appcompat)
    implementation(AppDependencies.androidStartup)
    implementation(AppDependencies.coreKtx)

    implementation(AppDependencies.lifecycleLog)

    hiltCoroutinesAnnotation()
    implementation(AppDependencies.lifecycle)
    implementation(AppDependencies.kotlin)
    implementation(AppDependencies.composeNavigation)

    implementPlatform(firebaseAnnotation)
    implementation(AppDependencies.firebase)

    implementation(AppDependencies.retrofit)

    implementation(AppDependencies.timber)
    implementation(AppDependencies.dataStorePreferences)

    testRuntimeOnly(AppDependencies.Test.jUnitRuntime)
}