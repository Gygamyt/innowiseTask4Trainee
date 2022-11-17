pipeline {
    agent any
    stages {
        stage('Git Push') {
            steps {
                git url: 'https://github.com/Gygamyt/innowiseTask4Trainee.git'
            }
        }
        stage('Tests') {
            steps {
                  sh "chmod 700 /var/jenkins_home/workspace/test/./src/main/resources/driver/chromedriver"
                  sh "chmod +x gradlew"
                  sh "./gradlew clean test"
            }
        }
            }
        post {
               always {
                       allure includeProperties: false, jdk: '', properties: [[key: 'allure.results.directory', value: 'build/allure-results']], report: 'target/allure-report', results: [[path: 'build/allure-results']]
               }
            }
        }