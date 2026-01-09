plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

allprojects {
    configurations.configureEach {
        resolutionStrategy.force("androidx.activity:activity-compose:1.12.2")
    }
}


tasks.register("syncWebDev") {
    dependsOn(":shared-logic:syncJsToAngularDev")
}

tasks.register("syncWebProd") {
    dependsOn(":shared-logic:syncJsToAngularProd")
}

tasks.register("syncWeb") {
    dependsOn("syncWebDev")
}
