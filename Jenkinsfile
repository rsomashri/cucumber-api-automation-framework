pipeline {
    agent any
    stages {
        stage('Test') {
        agent { dockerfile true }
            steps {
               sh './run_test.sh true'
               echo "i'm here"
            }
        }
    }
}
