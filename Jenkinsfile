pipeline {
    agent any
    stages {
        stage('Checkout') { steps { checkout scm } }
        stage('Build') { steps { sh 'mvn -B -DskipTests clean package' } }
        stage('Test') { steps { sh 'mvn test -DskipTests=false' } }
        stage('Archive') { steps { archiveArtifacts artifacts: 'reports/**', fingerprint: true } }
    }
}