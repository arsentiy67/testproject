pipeline {
    agent any

    parameters {
        choice(choices: ['chrome', 'firefox'], name: 'driver', description: 'Choose browser')
    }

    environment {
        WEB_DRIVER = "${params.driver}"
        sh(
            script: "print ${WEB_DRIVER}"
        )
    }


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