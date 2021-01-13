plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
}

group = "com.yt8492"
version = "1.0.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains:kotlin-react:17.0.0-pre.129-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-react-dom:17.0.0-pre.129-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-css:1.0.0-pre.131-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.130-kotlin-1.4.21")
    implementation(npm("react-markdown", "5.0.3"))
    implementation(npm("remark-gfm", "1.0.0"))
    implementation(npm("react-syntax-highlighter", "15.4.3"))
}

kotlin {
    js(IR) {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}