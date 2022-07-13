FROM maven:3.8.6-openjdk-18 as maven
RUN mkdir /apiautomation
COPY . /apiautomation
WORKDIR /apiautomation
RUN mvn dependency:go-offline -B

