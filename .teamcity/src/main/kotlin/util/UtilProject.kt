package util

import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object UtilProject : Project({
    uuid = "077cff89-d1d3-407b-acc0-88446a99dec7-2"
    id("Util")
    name = "Util"

    buildType(WarmupEc2Agent)
})
