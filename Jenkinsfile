/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven:3.9.8-eclipse-temurin-21-alpine' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Test') {
            steps {
            sh 'echo "Fail!"; exit 0'
            }
        }
        stage('Sanity check') {
            steps {
                input "Does the staging environment look ok?"
            }
        }
    }
    post {
        always {
            echo "Hello Jenkins"
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
                echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
