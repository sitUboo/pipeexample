println "The build is " + env.BUILD_NUMBER

stage('checkout'){
   // checkout code
   node {
      git 'git@github.com:cloudbees/customers.git'
      gitSha = sh(returnStdout: true, script: 'cat ./.git/refs/heads/master').trim()
      sh "echo running test"
      step([
        $class: 'GitHubCommitStatusSetter',
        commitShaSource: [$class: 'ManuallyEnteredShaSource', sha: gitSha],
        //reposSource: [$class: 'AnyDefinedRepositorySource'],
        reposSource: [$class: 'ManuallyEnteredRepositorySource', url: 'https://github.com/cloudbees/customers' ],
        contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'Quality Checks Passed' ],
        statusResultSource: [ $class: 'ConditionalStatusResultSource', results: [[$class: 'AnyBuildResult', message: 'Succeeded', state: 'SUCCESS']] ]
      ]);
//step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'Quality Checks Passed'], statusResultSource: [$class: 'ConditionalStatusResultSource', results: [[$class: 'AnyBuildResult', state: 'SUCCESS', message: "Succeeded"]]]])
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
