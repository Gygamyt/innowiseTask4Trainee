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
                sh "gradle cleanTest test"
            }
        }
    }
}