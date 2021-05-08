pipeline {
   agent any

    environment {
        PORT="9990"
        IMAGE_TAG="gateway"
        CONTAINER_NAME="gateway-service"
        DB_URL=credentials('DB_URL')
        DB_USER=credentials('DB_USER')
        DB_PASS=credentials('DB_PASS')
    }
   stages {
      stage('checkout'){
          steps {
            git branch: 'master', url: 'https://gitlab.com/210301-java-azure/project3/revature-max-gateway-service.git'
          }
      }
      stage('clean') {
         steps {
            sh 'sh gradlew clean'
         }
      }
      stage('package') {
         steps {
            sh 'sh gradlew bootJar'
         }
      }
      stage('remove previous image if exists') {
            steps {
                sh 'docker rmi -f ${IMAGE_TAG} || true'
            }
        }

       stage('create image') {
            steps {
                sh 'docker build --build-arg DEPENDENCY=build/dependency -t ${IMAGE_TAG} -f Dockerfile .'
            }
        }
        stage('remove previous container if exists') {
            steps {
                sh 'docker stop ${CONTAINER_NAME} || true'
            }
        }
        stage('create container') {
            steps {
                print 'DB_URL.collect { it }=' + DB_URL.collect { it }
                print 'DB_USER.collect { it }=' + DB_USER.collect { it }
                print 'DB_PASS.collect { it }=' + DB_PASS.collect { it }
                sh 'docker run -d --rm --network host -p ${PORT}:${PORT} -e DB_USER=${DB_USER} -e DB_PASS=${DB_PASS} -e DB_URL=${DB_URL} --name ${CONTAINER_NAME} ${IMAGE_TAG}'
            }
        }
    }
}
