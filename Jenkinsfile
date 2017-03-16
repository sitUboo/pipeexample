println "The build is " + env.BUILD_NUMBER

stage('checkout'){
   // checkout code
   node {
      git 'git@github.com:cloudbees/customers.git'
      gitSha = sh(returnStdout: true, script: 'cat ./.git/refs/heads/master').trim()
      sh "echo running test"
      sh 'curl -H "Content-Type: application/json" --data @/Users/stevendeal/CloudBees/customers/message.json -u sitUboo:45d5a484c14ead76192757a6c2566a55c06e542c https://api.github.com/repos/cloudbees/customers/statuses/7b4b6a41e6f98806f1f330720bfb909f2597fd24'
//
}
exit
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
