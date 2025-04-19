pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'JDK 21'
    }

    stages {
        stage('Clone Code') {
            steps {
                git branch: 'main', url: 'https://github.com/kaushal10973/todo-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy with Puppet') {
            steps {
                echo 'Deploying with Puppet...'
                bat '''
                if not exist C:\\deploy mkdir C:\\deploy
                copy target\\todo-app-1.0.jar C:\\deploy\\todo-app.jar
                '''
            }
        }
    }

post {
    success {
        junit '**/target/surefire-reports/*.xml'
        echo 'Build and Deployment Successful!'
    }
    failure {
        echo 'Something went wrong.'
    }
}

