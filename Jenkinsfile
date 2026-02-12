pipeline {
agent any
// password vgdo tbxb yiyf smar
stages {
//    stage('Checkout') {
//            steps {
//                checkout scm
//            }
//        }
//    stage('Workspace') {
//        steps {
//            echo "Workspace is: ${env.WORKSPACE}"
//            bat 'dir'
//        }
//    }
//    stage('Init') {
//        steps {
//            bat 'mvn clean'
//        }
//    }
//
//    stage('Test') {
//        steps {
//            bat 'mvn test'
//            junit '**/target/surefire-reports/*.xml'
//            cucumber reportTitle: 'Myreport',
//                    fileIncludePattern: 'target/example-report.json'
//        }
//    }
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


//    stage("slack") {
//           steps {
//               bat '''
//                   curl -X POST -H "Content-type: application/json" --data "{""text"":""testing slack""}" "%SLACK_WEBHOOK%"
//               '''
//           }
//       }

        stage('Verify Tag') {
            steps {
                bat '''
                echo ===============================
                echo JOB_NAME=%JOB_NAME%
                echo BUILD_NUMBER=%BUILD_NUMBER%
                echo TAG_NAME=%VERSION%
                echo ===============================
                '''
            }
        }

        stage('Fail if Not a Tag') {
            when {
                not { buildingTag() }
            }
            steps {
                bat '''
                echo ERROR: This pipeline runs ONLY for Git tags
                exit /b 1
                '''
            }
        }

        stage('Checkout Tag') {
            when {
                buildingTag()
            }
            steps {
                checkout scm
            }
        }

        stage('Build') {
            when {
                buildingTag()
            }
            steps {
                bat '''
                echo Building application for tag %VERSION%
                REM ---- PUT YOUR BUILD COMMANDS HERE ----
                REM mvn clean package
                REM npm install && npm run build
                '''
            }
        }

        stage('Deploy') {
            when {
                buildingTag()
            }
            steps {
                bat '''
                echo Deploying version %VERSION%
                REM ---- PUT YOUR DEPLOY COMMANDS HERE ----
                REM xcopy /E /Y dist\\* C:\\deploy\\app\\
                '''
            }
        }







}

}