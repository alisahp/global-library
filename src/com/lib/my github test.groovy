properties([[$class: 'JiraProjectProperty'], parameters([string(defaultValue: 'v1', description: 'Please provide a version number', name: 'APP_VERSION', trim: false)])])
node {
    stage("pull repo"){
        git 'https://github.com/alisahp/nodejs_app.git'
    }
    stage("Build Image"){
        sh "docker build -t app1:${APP_VERSION} . "
    }
    stage("image tag"){
        sh ''' docker tag app1:${APP_VERSION}  984969484288.dkr.ecr.us-east-2.amazonaws.com/app1:${APP_VERSION}'''