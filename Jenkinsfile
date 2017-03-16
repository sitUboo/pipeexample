println "The build is " + env.BUILD_NUMBER

stage('checkout'){
   // checkout code
   node {
      git 'git@github.com:sitUboo/Yui.git'
      gitSha = sh(returnStdout: true, script: 'cat ./.git/refs/heads/master').trim()
//      git 'git@github.com:darinpope/offline-update-center.git'
      println "The branch is " + env.GIT_BRANCH
      sh "echo running test"
//      step([$class: 'GitHubSetCommitStatusBuilder', statusMessage: [state: 'success', content: 'Code Checks Passed']])
//        step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'Code Checks Passed'], statusResultSource: [$class: 'ConditionalStatusResultSource', results: [[$class: 'AnyBuildResult', state: 'SUCCESS', message: "Succeeded"]]]])
      step([
        $class: "GitHubCommitStatusSetter",
        commitShaSource: [$class: "ManuallyEnteredShaSource", sha: gitSha],
        //reposSource: [$class: "AnyDefinedRepositorySource"],
        reposSource: [$class: "ManuallyEnteredRepositorySource", url: "https://github.com/sitUboo/Yui" ],
        contextSource: [$class: "ManuallyEnteredCommitContextSource", context: "ci/jenkins/foo" ],
        errorHandlers: [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
        statusResultSource: [ $class: "ConditionalStatusResultSource", results: [
            [$class: "AnyBuildResult", message: 'Test', state: 'success']] ]
      ]);
   }
}

stage('build'){

   node {
      parallel (
        phase1: { sh "echo p1; sleep 20s; echo phase1" },
//        phase2: { sh "echo p2; sleep 40s; echo phase2" }
      )
      println "The build is " + env.BUILD_NUMBER
      sh "echo run this after both phases complete"
//      step([$class: 'GitHubSetCommitStatusBuilder', statusMessage: [state: 'success', content: 'Compile Passed']])
   }
}
