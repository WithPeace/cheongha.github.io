import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {}
        binaries.executable()
    }
    js {
        browser {}
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.compose.multiplatform.constraint.layout)
            }
        }
        val intermediateMain by creating {
            dependsOn(commonMain) // 공통 모듈 사용
        }

        val wasmJsMain by getting {
            dependsOn(intermediateMain) // intermediateMain의 코드를 상속
        }

        val jsMain by getting {
            dependsOn(intermediateMain)
        }
    }
}

compose.experimental {
    web.application {}
}
