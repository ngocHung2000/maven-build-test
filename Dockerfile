FROM openjdk:17-oracle
WORKDIR /app
COPY ./target/product-service.jar ./run.jar
EXPOSE 8080
# Switch user
RUN groupadd -r ngochung1809 && \
    useradd --no-log-init -r -g ngochung1809 ngochung1809
USER ngochung1809

CMD ["java","-jar","run.jar"]

