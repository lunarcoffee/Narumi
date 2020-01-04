plugins { kotlin("jvm") version "1.3.61" }

group = "dev.lunarcoffee"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")

    implementation("com.google.code.gson:gson:2.8.6")

    implementation("io.ktor:ktor-client-core:1.3.0-rc")
    implementation("io.ktor:ktor-client-websockets:1.3.0-rc")
    implementation("io.ktor:ktor-client-cio:1.3.0-rc")
    implementation("io.ktor:ktor-client-json:1.3.0-rc")
    implementation("io.ktor:ktor-client-gson:1.3.0-rc")
}

tasks {
    compileKotlin { kotlinOptions.jvmTarget = "1.8" }
    compileTestKotlin { kotlinOptions.jvmTarget = "1.8" }
}
