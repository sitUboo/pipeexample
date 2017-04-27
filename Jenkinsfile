println "The build is " + env.BUILD_NUMBER

stage('checkout'){
   // checkout code
   node {
           git credentialsId: '515e6bbd-7fd2-48ea-ae16-1140719c7df5', url: 'git@github.com:sitUboo/Yui.git'
           sh "echo running build..."
//           [$class: 'GitHubCommitStatusSetter',
//             commitShaSource: [$class: 'ManuallyEnteredShaSource', sha: gitSha],
//             reposSource: [$class: 'ManuallyEnteredRepositorySource', url: 'https://github.com/cloudbees/customers' ],
//             statusBackrefSource: [ $class: 'BuildRefBackrefSource' ],
//             contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'Quality Checks Passed' ],
//             statusResultSource: [ $class: 'ConditionalStatusResultSource', results: [[$class: 'AnyBuildResult', message: 'Succeeded', state: 'SUCCESS']] ]
      //  ]
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
