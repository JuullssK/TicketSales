
pipeline {
    agent any

    environment {
        MAVEN_CMD = 'C:\\Program Files\\apache-maven-3.10.0\\bin\\mvn.cmd'
    }

    stages {
        stage('Build') {
            steps {
                dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\TicketSales') {
                    bat 'call "%MAVEN_CMD%" compile'
                }
            }
        }

        stage('Test') {
            steps {
                dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\TicketSales') {
                    bat 'call "%MAVEN_CMD%" test'
                }
            }
        }

        stage('Validate Project') {
            steps {
                dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\TicketSales') {
                    bat 'call "%MAVEN_CMD%" validate'
                }
            }
        }

        stage('Package') {
            steps {
                dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\TicketSales') {
                    bat 'call "%MAVEN_CMD%" package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            echo 'Сборка успешно завершена.'
        }
        failure {
            echo 'Ошибка сборки. Проверьте Console Output.'
        }
    }
}
