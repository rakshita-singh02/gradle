package util

import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object UtilPerformanceProject : Project({
    uuid = "fdc4f15a-e253-4744-a1b3-bcac37b18189-2"
    id("Util_Performance")
    name = "Performance"

    buildType(AdHocPerformanceScenarioLinux)
    buildType(AdHocPerformanceScenarioWindows)
    buildType(AdHocPerformanceScenarioMacOS)

    params {
        param("env.GRADLE_ENTERPRISE_ACCESS_KEY", "%ge.gradle.org.access.key%")
    }
})
