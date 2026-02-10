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
            cucumber reportTitle: 'Myreport',
                    fileIncludePattern: 'target/example-report.json'
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
        publishHTML([
            allowMissing: false,
            reportDir: 'target/site/jacoco',
            reportFiles: 'index.html',
            reportName: 'JaCoCo Coverage Report',
            keepAll: true,
            alwaysLinkToLastBuild: true
        ])

    }

}


}