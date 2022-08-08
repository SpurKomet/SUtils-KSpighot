import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    id("io.papermc.paperweight.userdev") version "1.3.6"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
    id("xyz.jpenilla.run-paper") version "1.0.6"

}

val mcAPIVersion = "1.19"
val mcVersion = "$mcAPIVersion"

group = "de.spurkomet"
version = mcVersion

repositories {
    mavenCentral()
    maven("https://repo.md-5.net/content/groups/public/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    paperDevBundle("$mcVersion-R0.1-SNAPSHOT")

    // KSpigot dependency
    compileOnly("net.axay:kspigot:1.19.0")
    compileOnly("org.apache.httpcomponents:httpclient:4.5.13")
    compileOnly("org.apache.httpcomponents:httpmime:4.5.13")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.7.0")
    compileOnly("LibsDisguises:LibsDisguises:10.0.28")
    compileOnly("io.papermc.paper:paper-api:${mcVersion}-R0.1-SNAPSHOT")

    implementation(group = "com.github.twitch4j", name = "twitch4j", version = "1.10.0")
    // or using it into compile
    api(group = "com.github.twitch4j", name = "twitch4j", version = "1.10.0")
}

tasks {
    build {
        dependsOn(reobfJar)
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}
bukkit {
    name = "SUtils"
    description = "Utils Plugin von SpurKomet"
    apiVersion = mcAPIVersion
    authors = listOf(
        "SpurKomet",
    )
    main = "$group.sutils.InternalMainClass"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:kspigot:1.19.0",
        "org.apache.httpcomponents:httpclient:4.5.13",
        "org.apache.httpcomponents:httpmime:4.5.13"
    )

}