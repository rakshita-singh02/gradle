package promotion

import common.Os
import common.gradleWrapper
import common.requiresOs
import jetbrains.buildServer.configs.kotlin.v2019_2.AbsoluteId
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.CheckoutMode
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import vcsroots.gradlePromotionMaster

// GradleBuildTool_Master_Promotion_SanityCheck
object SanityCheck : BuildType({
    // From Gradle_Promotion_MasterSanityCheck
    uuid = "bf9b573a-6e5e-4db1-88b2-399e709026b5-1"
    id = AbsoluteId("GradleBuildTool_Check_Promotion_SanityCheck")
    name = "SanityCheck"
    description = "Sanity check for promotion project"

    vcs {
        root(AbsoluteId(gradlePromotionMaster))

        checkoutMode = CheckoutMode.ON_AGENT
        this.cleanCheckout = cleanCheckout
        showDependenciesChanges = true
    }

    steps {
        gradleWrapper {
            tasks = "tasks"
            gradleParams = ""
            param("org.jfrog.artifactory.selectedDeployableServer.defaultModuleVersionConfiguration", "GLOBAL")
        }
    }

    triggers {
        vcs {
            branchFilter = ""
        }
    }

    requirements {
        requiresOs(Os.LINUX)
    }
})
