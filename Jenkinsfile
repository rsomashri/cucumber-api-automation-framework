pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {               
               mvn test              
            }
        }
    }
}
