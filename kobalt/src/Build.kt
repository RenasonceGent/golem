import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.kotlin.*

val repos = repos("https://dl.bintray.com/kyonifer/maven/")


val p = project {

    name = "del"
    group = "com.example"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
        compile("golem:golem-core:0.6")
        compile("golem:golem-backend-ejml:0.6")
        // Shouldn't be needed, these are deps of golem-core
        compile("org.knowm.xchart:xchart:3.1.0")
        // Shouldn't be needed, these are deps of golem-backend-ejml
        compile("org.ejml:all:0.27")
    }

    dependenciesTest {
        compile("org.testng:testng:")

    }

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.MainKt"
    }


}
