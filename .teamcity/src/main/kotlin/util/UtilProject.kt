package util

import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.versionedSettings
import vcsroots.gradleMaster

object UtilProject : Project({
    uuid = "077cff89-d1d3-407b-acc0-88446a99dec7-1"
    id("Util")
    name = "Util"

    buildType(WarmupEc2Agent)
})
