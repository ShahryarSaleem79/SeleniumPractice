pipeline {
    agent any

    stages {
        
        stage('Checkout') {
            steps {
                echo 'Checkout Code'
                git branch: 'master', url: 'https://github.com/ShahryarSaleem79/SeleniumPractice.git'
                
            }
        }

        stage('Build') {
            steps {
                echo 'mvn clean complie'
                sh 'mvn clean compile'
            }
        }
    }
}
 
