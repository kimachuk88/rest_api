pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps{

                sh 'mvn -Dtest=TestClientMethods test'
                  
            }
             
        }
    }
}
