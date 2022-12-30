rootProject.name = ("Tradi")
include(
    "app",
    "modules:common:ui",
    "modules:presentation",
    "modules:repository",
    "modules:domain:model",
    "modules:providers:network"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
