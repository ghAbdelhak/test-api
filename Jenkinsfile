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
        cucumber buildStatus: 'UNSTABLE',
                failedFeaturesNumber: 1,
                failedScenariosNumber: 1,
                skippedStepsNumber: 1,
                failedStepsNumber: 1,
                classifications: [
                        [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                        [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                ],
                reportTitle: 'Myreport',
                fileIncludePattern: 'target/*cucumber-report.json',
                sortingMethod: 'ALPHABETICAL',
                trendsLimit: 100
    }
}
}