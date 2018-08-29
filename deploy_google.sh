#!/usr/bin/env bash

# more bash-friendly output for jq
JQ="jq --raw-output --exit-status"

build_gcr_image(){
    echo build_gcr_image

    docker build -t mangold-image-$LOWER_CIRCLE_BRANCH:$CIRCLE_BUILD_NUM .
    docker tag mangold-image-$LOWER_CIRCLE_BRANCH:$CIRCLE_BUILD_NUM gcr.io/$PROJECT_ID/swarm-microservice-boilerplate-$LOWER_CIRCLE_BRANCH:$CIRCLE_BUILD_NUM
}

push_gcr_image(){
    echo push_gcr_image

	gcloud docker -- push gcr.io/$PROJECT_ID/swarm-microservice-boilerplate-$LOWER_CIRCLE_BRANCH:$CIRCLE_BUILD_NUM
}


deploy_gke(){
    echo deploy_gke

    kubectl set image deployment/trswarm-microservice-boilerplate-deployment trswarm-microservice-boilerplate-deployment=gcr.io/$PROJECT_ID/swarm-microservice-boilerplate-$LOWER_CIRCLE_BRANCH:$CIRCLE_BUILD_NUM
}

build_gcr_image
push_gcr_image
#deploy_gke