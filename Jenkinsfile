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
                bat 'mvn -Dtest=TestClientMethods test'  
            }
            post{
                archive (includes: 'pkg/*.gem')
            }
             
        }
    }
}
