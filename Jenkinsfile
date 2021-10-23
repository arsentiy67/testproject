pipeline {
    agent any

    properties([
      parameters([
        string(name: 'driver', defaultValue: 'chrome')
      ])
    ])


    stages {
        stage('Clean') {
            steps {
                cleanWs()
            }
        }
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
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