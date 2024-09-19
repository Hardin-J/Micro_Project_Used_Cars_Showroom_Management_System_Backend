FROM openjdk:18
WORKDIR /app
COPY ./target/used_car_showroom_management_system-0.0.1-SNAPSHOT.jar /app
EXPOSE 1310
CMD ["java", "-jar", "used_car_showroom_management_system-0.0.1-SNAPSHOT.jar"]