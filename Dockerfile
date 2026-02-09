FROM maven:3.8.5 AS builder

WORKDIR /builder
COPY ./ .
RUN mvn clean install

FROM openjdk:25-ea-17-oracle AS runner
ENV MAINTAINER=hungtn

ENV APP_COLOR=red

WORKDIR /app

ADD https://raw.githubusercontent.com/ngocHung2000/maven-build-test/refs/heads/master/Dockerfile docker-app

# COPY ./target/product-service.jar ./run.jar

COPY --from=builder /builder/target/product-service.jar ./run.jar

EXPOSE 8080

# Switch user
RUN groupadd -r ngochung1809 && \
    useradd --no-log-init -r -g ngochung1809 ngochung1809
USER ngochung1809

CMD ["java","-jar","run.jar"]