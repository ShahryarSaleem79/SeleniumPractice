pipeline {
    agent any

    stages {
        
        stage('Run TestNG Tests') {
            steps {
                echo 'Running TestNG tests from testng.xml'
                sh 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }
    }
}
