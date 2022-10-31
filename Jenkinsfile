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
        stage('Report'){
        steps{
            allure includeProperties: false, jdk: '', properties: [[key: 'allure.results.directory', value: 'target/build/allure-results']], report: 'target/allure-report', results: [[path: 'target/build/allure-results']]
            }
        }
    }
}