plugins {
    kotlin("jvm") version "2.0.21"
}

sourceSets {
    main {
        java.srcDirs("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.10.2"
    }
}
