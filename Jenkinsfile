pipeline {
    agent any

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['development', 'staging', 'production'],
               description: 'Deployment environment')
        booleanParam(name: 'DEPLOY', defaultValue: true,
                     description: 'Deploy the packaged JAR')
    }

    environment {
        APP_NAME = 'declarative-pipeline-demo'
    }

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Building ${env.JOB_NAME} on ${env.NODE_NAME}"
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
                archiveArtifacts artifacts: 'target/*.jar',
                                 fingerprint: true,
                                 allowEmptyArchive: false
            }
        }

        stage('Deploy') {
            when {
                expression { return params.DEPLOY }
            }
            steps {
                script {
                    def targetDir = "deploy/${params.ENVIRONMENT}"
                    sh "mkdir -p '${targetDir}' && cp target/*.jar '${targetDir}/'"
                    echo "Deployed artifact to ${targetDir}"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded: build, tests, package, and optional deploy completed.'
        }
        failure {
            echo 'Pipeline failed. Inspect the failed stage in Stage View.'
        }
        unstable {
            echo 'Pipeline is unstable because test results contain failures.'
        }
    }
}
