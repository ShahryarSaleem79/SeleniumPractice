pipeline {
    agent any

    tools {
        jdk 'JDK-21'          // configured in Jenkins Global Tools
        maven 'MAVEN-3.9.11'       // configured in Jenkins Global Tools
    }

    environment {
        BROWSER = 'chrome'
        ENV = 'qa'
    }
    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/ShahryarSaleem79/SeleniumPractice.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling the project...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Selenium tests on ${BROWSER} in ${ENV} environment"
                sh '''
                    mvn test \
                    -Dbrowser=${BROWSER} \
                    -Denv=${ENV} \
                    -DsuiteXmlFile=testng.xml
                '''
            }
        }

        stage('Publish Test Report') {
            steps {
                echo 'Publishing TestNG Report'
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Automation Report'
                ])
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
            archiveArtifacts artifacts: 'target/**/*.xml', fingerprint: true
        }

        success {
            echo 'Automation tests passed ✅'
        }

        failure {
            echo 'Automation tests failed ❌'
        }
    }
}
