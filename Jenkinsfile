
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    environment {
        MAVEN_CMD = 'C:\\Program Files\\apache-maven-3.10.0\\bin\\mvn.cmd'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\TicketSales') {
                    bat 'call "%MAVEN_CMD%" clean compile'
                }
            }
        }

        stage('Static Analysis') {
            steps {
                dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\TicketSales') {
                    bat 'call "%MAVEN_CMD%" checkstyle:check'
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
