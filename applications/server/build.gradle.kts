import org.gradle.jvm.tasks.Jar

plugins {
  kotlin("jvm")
  application
}

application {
  mainClassName = "io.kfec.App"
}

dependencies {
  compile(kotlin("stdlib"))
}

val fatJar = task("fatJar", type = Jar::class) {
  manifest {
    attributes["Main-Class"] = application.mainClassName
  }
  from(configurations.runtime.map({ if (it.isDirectory) it else zipTree(it) }))
  with(tasks["jar"] as CopySpec)
}

tasks {
  "build" {
    dependsOn(fatJar)
  }
}
