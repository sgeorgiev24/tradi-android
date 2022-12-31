rootProject.name = ("Tradi")
include(
    "app",
    "modules:common:ui",
    "modules:presentation",
    "modules:domain:repository",
    "modules:domain:model",
    "modules:providers:network"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
