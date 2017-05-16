
stage('s1'){
   node('linux') {
       sh "echo running build..."
   }
}

stage('s2'){
   node('linux') {
      parallel (
        phase1: { sh "echo p1; sleep 20s; echo phase1" },
        phase2: { sh "echo p2; sleep 40s; echo phase2" }
      )
      println "The build is " + env.BUILD_NUMBER
      sh "echo run this after both phases complete"
   }
}

stage('s3'){
   node('linux') {
       sh "echo running build...s3"
   }
}

stage('s4'){
   node('linux') {
       sh "echo running build...s4"
   }
}

stage('s5'){
   node('linux') {
       sh "echo running build...s5"
   }
}
