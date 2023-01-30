FROM azul/zulu-openjdk:11.0.10
RUN set -x \
    mkdir -p /app
COPY ./build/libs/PruebaTecnica-0.1-all.jar /app/
EXPOSE 8080
WORKDIR /app
CMD ["java", "-jar", "PruebaTecnica-0.1-all.jar"]