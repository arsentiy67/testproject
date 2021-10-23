pipeline {
    agent any

    parameters {
        choice(choices: ['chrome', 'firefox'], name: 'driver', description: 'Choose browser')
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
                withEnv(['driver="${params.driver}"']) {
                    sh '''
                        chmod +x ./mvnw
                        ./mvnw clean test
                    '''
                }
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