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
            echo 'Build and Deployment Successful!'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            // Optional email notification (set up SMTP in Jenkins first)
            // mail to: 'your-email@example.com',
            //      subject: "SUCCESS: ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
            //      body: "Your pipeline ran successfully. View it here: ${env.BUILD_URL}"
        }
        failure {
            echo 'Something went wrong.'
            // Optional email notification
            // mail to: 'your-email@example.com',
            //      subject: "FAILURE: ${env.JOB_NAME} Build #${env.BUILD_NUMBER}",
            //      body: "Something broke. Check here: ${env.BUILD_URL}"
        }
    }

}
