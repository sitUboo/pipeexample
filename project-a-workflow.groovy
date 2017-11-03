stage('s1'){
   node('linux') {
       sh "for x in `seq 1 10000000`;do echo blah $x;done;""
   }
}
