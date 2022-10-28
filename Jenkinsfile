pipeline {
    agent any
    tools {
        gradle 'Gradle'
        jdk 'Java'
    }
    stages {
        stage('Git Push') {
            steps {
                git credentialsId: 'git_ssh', url: 'github.com/Gygamyt/innowiseTask4Trainee'
            }
        }
        stage('Tests') {
            steps {
                sh "gradle cleanTest test"
            }
        }
    }
}