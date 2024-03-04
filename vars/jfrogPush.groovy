def call(){
    withCredentials([usernamePassword(
            credentialsId: "jfrog",
            usernameVariable: "USER",
            passwordVariable: "PASS"
    )]) {
        sh "jfrog rt config --interactive=false --url="https://your-artifactory-url" --user=$USER --password=$PASS --interactive=false"
    }
    //sh "docker image push ${hubUser}/${project}:${ImageTag}"
    sh "jfrog rt u "path/to/your/artifact" "your-repository-in-jfrog/" --recursive=true"   
}


// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//      docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }
