FROM 617782583250.dkr.ecr.us-east-2.amazonaws.com/jx-dev/openjdk:8-jdk-slim
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar /opt/app.jar
WORKDIR /opt
CMD ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-jar", "app.jar"]
