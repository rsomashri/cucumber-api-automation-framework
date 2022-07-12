pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
                ./run_test.sh true
            }
        }
    }
}