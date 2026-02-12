pipeline {
agent any
// password vgdo tbxb yiyf smar
stages {
    stage('Checkout') {
            steps {
                checkout scm
            }
        }
    stage('Workspace') {
        steps {
            echo "Workspace is: ${env.WORKSPACE}"
            bat 'dir'
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
//    stage('Build') {
//        steps {
//            bat 'mvn install'
//        }
//    }
//
//    stage('Archive') {
//        steps {
//            archiveArtifacts artifacts: 'target/*.jar'
//        }
//    }
//
//    stage('Documentation') {
//        steps {
//            script {
//                bat 'mvn javadoc:javadoc'
//
//                // Clean up previous 'doc' folder if it exists
//                bat 'if exist doc rmdir /S /Q doc'
//                bat 'mkdir doc'
//
//                // Copy Javadoc content to the 'doc' folder
//                bat 'xcopy /E /I /Y target\\site doc'
//
//                // Delete existing doc.zip if it exists
//                bat 'if exist doc.zip del /Q doc.zip'
//
//                // Create the ZIP file with the new content
//                bat 'powershell -Command "Compress-Archive -Path doc\\* -DestinationPath doc.zip -Force"'
//
//                // Archive the doc.zip file for Jenkins artifacts
//                archiveArtifacts artifacts: 'doc.zip', fingerprint: true
//            }
//        }
//    }
//
//        stage('Deploy') {
//            steps {
//                    bat 'mvn  deploy'
//                }
//        }


    stage("slack") {
           steps {
               bat '''
                   curl -X POST -H "Content-type: application/json" --data "{""text"":""testing slack""}" "%SLACK_WEBHOOK%"
               '''
           }
       }







}

}