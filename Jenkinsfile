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
                bat "gradle cleanTest test"
            }
        }
        stage('Report') {
            steps{
                allure includeProperties: false, jdk: '', properties: [[key: 'allure.results.directory', value: 'target/allure-results']], results: [[path: 'target/allure-report']]
            }
        }
    }
}