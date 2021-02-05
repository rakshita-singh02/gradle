/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package promotion

import common.gradleWrapper
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.schedule
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import vcsroots.gradlePromotionBranches

object StartReleaseCycleTest : BasePromotionBuildType(vcsRootId = gradlePromotionBranches, cleanCheckout = false) {
    init {
        uuid = "59823634-f79d-4c11-bbca-782957a7d65c-2"
        id("Promotion_AllBranchesStartReleaseCycleTest")
        name = "Start Release Cycle Test"
        description = "Test for Start Release Cycle pipeline"

        steps {
            gradleWrapper {
                name = "PromoteTest"
                tasks = "clean promoteStartReleaseCycle"
                useGradleWrapper = true
                gradleParams = "-PconfirmationCode=startCycle -PtestRun=1"
            }
        }

        triggers {
            vcs {
                branchFilter = "+:master"
            }
            schedule {
                schedulingPolicy = daily {
                    hour = 3
                }
                branchFilter = "+:master"
                triggerBuild = always()
                withPendingChangesOnly = false
            }
        }
    }
}
