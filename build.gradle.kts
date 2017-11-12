allprojects {

  group = "io.kfec"

  version = "1.0"

  repositories {
    jcenter()
  }
}

plugins {
  base
}

dependencies {
  // Make the root project archives configuration depend on every subproject
  subprojects.forEach {
    archives(it)
  }
}
