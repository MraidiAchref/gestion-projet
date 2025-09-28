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

        stage('Build docker image') {
            steps {
                sh 'docker build -t mraidiachref/gestion-projet:$GIT_COMMIT .'
            }
        }

        stage('Push Docker Image') {   // plugin docker pipeline
            steps {
                withDockerRegistry(credentialsId: 'DOCKER_HUB_PAT', url: "") {
                    sh 'docker push mraidiachref/gestion-projet:$GIT_COMMIT '
                }
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
