pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
                echo "i'm here 1"
               sh './run_test.sh true'
               echo "i'm here 2"

            }
        }
    }
}
