pipeline {
agent any
// password vgdo tbxb yiyf smar
stages {
    stage('Checkout') {
            steps {
                checkout scm
            }
        }
    stage('Init') {
        steps {
            bat 'mvn clean'
        }
    }

    stage('Test') {
        steps {
            bat 'mvn test'
            junit '**/target/surefire-reports/*.xml'
        }
    }
    stage('Build') {
        steps {
            bat 'mvn install'
            archiveArtifacts artifacts: 'target/*.jar'
        }
    }


stage('Deploy') {
    steps {
            bat 'mvn  deploy'
        }
    }





}
post {
    always {
        cucumber reportTitle: 'Myreport',
                fileIncludePattern: 'target/cucumber-report.json'
    }
}
}