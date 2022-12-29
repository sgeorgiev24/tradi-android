rootProject.name = ("Tradi")
include(
    "app",
    "modules:common:ui",
    "modules:presentation",
    "modules:domain:model",
    "modules:providers:firebase"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
