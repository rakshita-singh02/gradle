package vcsroots

import jetbrains.buildServer.configs.kotlin.v2019_2.AbsoluteId
import jetbrains.buildServer.configs.kotlin.v2019_2.CheckoutMode
import jetbrains.buildServer.configs.kotlin.v2019_2.VcsSettings

val gradleMaster = "GradleBuildToolMaster"
val gradleRelease = "GradleBuildToolRelease"
val gradlePromotionMaster = "GradleBuildTool_GradlePromoteMaster"
val gradlePromotionBranches = "GradleBuildTool_GradlePromoteBranches"

fun VcsSettings.useAbsoluteVcs(absoluteId: String) {
    root(AbsoluteId(absoluteId))

    checkoutMode = CheckoutMode.ON_AGENT
    this.cleanCheckout = cleanCheckout
    showDependenciesChanges = true
}
