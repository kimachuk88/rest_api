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
          withMaven(
        maven: 'M3',
        mavenSettingsConfig: 'my-maven-settings',
        mavenLocalRepo: '.repository') {
                sh 'mvn -Dtest=TestClientMethods test'
                  }
            }
             
        }
    }
}
