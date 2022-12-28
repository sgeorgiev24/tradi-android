import AppDependencies.hilt

plugins {
    library()
    compose()
}

dependencies {
    implementation(AppDependencies.kotlin)
    implementation(AppDependencies.chromeTabs)
    hilt()
    implementation(AppDependencies.coroutines)
    implementation(AppDependencies.timber)
    implementation(AppDependencies.composeNavigation)
    implementation(AppDependencies.accompanist)
}