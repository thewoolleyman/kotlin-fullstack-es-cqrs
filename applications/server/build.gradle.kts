plugins {
  kotlin("jvm")
  id("com.github.johnrengelman.shadow") version "2.0.1"
  application
}

application {
  mainClassName = "io.kfec.App"
}

dependencies {
  compile(kotlin("stdlib"))
}
