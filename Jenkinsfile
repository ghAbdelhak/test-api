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
        recordCoverage(tools: [[parser: 'JACOCO']],
                id: 'jacoco', name: 'JaCoCo Coverage',
                sourceCodeRetention: 'EVERY_BUILD',
                qualityGates: [
                        [threshold: 60.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                        [threshold: 60.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]])

    }

}


}