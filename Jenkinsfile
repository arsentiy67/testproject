pipeline {
    agent any

    stages {
        stage('Clean') {
            com.epam.testproject.steps {
                cleanWs()
            }
        }
        stage('Checkout') {
            com.epam.testproject.steps {
                checkout scm
            }
        }
        stage('Build') {
            com.epam.testproject.steps {
                sh '''
                    chmod +x ./mvnw
                    ./mvnw clean test
                '''
            }
        }

    }

    post {
        always {
            script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
            }
        }
    }
}