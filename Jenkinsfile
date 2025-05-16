pipeline {
  agent any

  tools {
    maven 'MAVEN_3' // correspond au nom du Maven installé sur Jenkins
  }

  environment {
    SONARQUBE_SERVER = 'SonarQube' // nom du serveur configuré dans Jenkins > Manage Jenkins > Configure System
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/mon-utilisateur/mon-projet.git'
      }
    }

    stage('Build & SonarQube Analysis') {
      steps {
        withSonarQubeEnv("${SONARQUBE_SERVER}") {
          sh 'mvn clean verify sonar:sonar'
        }
      }
    }
  }
}
