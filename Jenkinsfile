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
                allure includeProperties: false, jdk: '', properties: [[key: 'allure.results.directory', value: 'target/allure-results']], report: 'target/allure-report', results: [[path: 'target/allure-results']]
            }
        }
    }
}