pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
               sh ./run_test.sh true
            }
        }
    }
}