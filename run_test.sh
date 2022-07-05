with_docker=$1
if [ "$with_docker" = true ];then
    docker build -t cucumber-api-automation-framework .
    docker run --name apiautomation -i cucumber-api-automation-framework mvn test
    docker rm -f apiautomation
else
	mvn test
fi
