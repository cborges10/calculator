pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Compile') {
            steps {
                echo 'Compiling the application...'
                sh "./gradlew compileJava"
            }
        }
        stage('Unit Test') {
            steps {
                echo 'Running unit tests...'
                sh "./gradlew test"
            }
        }
        stage('Code coverage') {
            steps {
                echo 'Generating code coverage report...'
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage('Static code analysis') {
            steps {
                echo 'Running Checkstyle analysis...'
                sh "./gradlew checkstyleMain"
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: 'Checkstyle Report'
                ])
            }
        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh "./gradlew build"
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh "docker build -t cborges10/calculator ."
            }
        }
    }
}