stage('checkout'){
   // checkout code
   node {
      git 'git@github.com:darinpope/offline-update-center.git'
   }
}

stage('build'){

   node {
      parallel (
        phase1: { sh "echo p1; sleep 20s; echo phase1" },
        phase2: { sh "echo p2; sleep 40s; echo phase2" }
      )
      sh "echo run this after both phases complete"
   }
}
