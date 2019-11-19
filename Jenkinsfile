#!/usr/bin/env groovy

pipeline {
  // Run the pipeline on a specified agent
  agent any

  stages {
    
    stage('cleanup') 
    {
      steps 
      {
        echo 'Clean workspace'
        cleanWs()
      }
    }


    stage('prepare') {
      steps {
        script {
          buildNumber = env.BUILD_NUMBER
          jobTypeName = env.JOB_BASE_NAME.tokenize('-').last()

          //Checkout the propertyfile specified in the job configuration.
          echo "checking out the property file: " + propertyFile

          checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: gitPropertyBranch]], doGenerateSubmoduleConfigurations: false, extensions: [], gitTool: 'Git_1.8.3.1', submoduleCfg: [], userRemoteConfigs: [[credentialsId: gitcredID, url: gitPropertyRepoUrl]], extensions: [
    [$class: 'DisableRemotePoll'],
    [$class: 'PathRestriction', excludedRegions: '', includedRegions: '*']] ]

          sh "ls -ltra"
          sh "pwd"
          //Read properties from the property file and assign the values to the variables.
          echo "Reading the property file: " + propertyFile

          property = readProperties file: propertyFile
          repoUrl = property.repoUrl
          mavenPath = property.mavenHome
          mavenSettingsFile = property.mavenSettingsPath
          pomFilePath = property.pomFilePath
          artifactTarget = property.artifactTarget
          appName = property.appName
          artifactBuildName = property.artifactBuildName
          pomVersionValue = property.pomVersionValue
          releaseVersionValue = property.releaseVersionValue
          artfactoryReleaseRepoName = property.artfactoryReleaseRepoName
          artifactoryReleaseRepoPath = property.artifactoryReleaseRepoPath
          pollingFrequency = property.pollingInterval
              
            properties([[$class: 'JiraProjectProperty'], [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false], parameters([string(defaultValue: '', description: 'Enter the branch name.', name: 'BRANCH_NAME', trim: true)])])
            checkoutBranch = BRANCH_NAME
          

          }
         
        }
      }
    
      
      //Checkout code from the branch parameter only for the Build/dev job.
      stage('Checkout') {
      when{
        expression { (jobTypeName == 'dev') || (jobTypeName == 'Build')  }
      }
      steps {
         
         echo 'Checking Out CODE from '+checkoutBranch+''
            
            checkout changelog: true, poll: true, scm: [$class: 'GitSCM', branches: [[name: checkoutBranch]], doGenerateSubmoduleConfigurations: false, extensions: [], gitTool: 'Git_1.8.3.1', submoduleCfg: [], userRemoteConfigs: [[credentialsId: gitcredID, url: repoUrl]]]

            sh "ls -ltra"
            sh "pwd"

          }
       }
}
    

 //Environemnt variables defined in the job configuration are pulled here.
  environment {
    
    propertyFile = "${propertyFile}"
    gitPropertyRepo = "${gitPropertyRepo}"
    gitPropertyRepoUrl = "${gitPropertyRepoUrl}"
    gitcredID = 'a000107'
    gitPropertyBranch = "${gitPropertyBranch}"
    
  }

  options {
    timestamps()
    buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '3'))
    disableConcurrentBuilds()
  }

}


