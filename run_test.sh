with_docker=$1
if [ "$with_docker" = true ];then
    docker build -t cucumber-api-automation-framework .
    docker run --name apiautomation -i cucumber-api-automation-framework mvn test
    echo "Running in docker container"
    docker rm -f apiautomation
else
	mvn test
fi
