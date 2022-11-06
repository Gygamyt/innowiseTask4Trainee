pipeline {
    agent any
    tools {
        gradle 'Gradle'
        jdk 'Java'
    }
    stages {
        stage('Git Push') {
            steps {
                git url: 'https://github.com/Gygamyt/innowiseTask4Trainee.git'
            }
        }
        stage('Tests') {
            steps {
                bat "gradle clean test"
            }
        }
        stage('Report') {
                steps {
                     always {
                               allure includeProperties: false, jdk: '', properties: [[key: 'allure.results.directory', value: 'build/allure-results']], report: 'target/allure-report', results: [[path: 'build/allure-results']]
                }
            }
        }
    }
}