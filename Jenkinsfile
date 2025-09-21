pipeline {
    agent any

    tools {
        maven 'maven-3.6.3'
        jdk 'JAVA_21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/MraidiAchref/gestion-projet.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
    }

    post {
        success {
            echo ' Build completed successfully.'
        }
        failure {
            echo ' Build failed.'
        }
    }
}
