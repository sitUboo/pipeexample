stage('s2'){
   node('linux') {
      parallel (
        phase1: { sh "echo p1; sleep 20s; echo phase1" },
        phase2: { sh "echo p2; sleep 40s; echo phase2" }
      )
      println "The build is " + env.BUILD_NUMBER
      sh "echo run this after both phases are complete..."
   }
}

stage('s3'){
   node('linux') {
      try {
         sh "wget http://www.somexyzurlicantfind.com"
      } catch (err){ 
         sh "echo this is the catch block"
     } 
   }
   node('linux') {
       sh "echo running build....s3"
   }
}

stage('s4'){
   node('linux') {
       sh "echo running build....s4"
   }
}

stage('s5'){
   node('linux') {
       sh "echo running build...s5."
   }
}
