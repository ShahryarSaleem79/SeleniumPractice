pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/ShahryarSaleem79/SeleniumPractice.git'
            }
        }

        stage('Run TestNG Tests') {
            steps {
                echo 'Running TestNG tests from testng.xml'
                sh 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }
    }
}
