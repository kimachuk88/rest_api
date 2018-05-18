pipeline {
    agent any
    stages {
        
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
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
