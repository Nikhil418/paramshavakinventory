FROM maven:alpine as builder

WORKDIR /apps

COPY src ./src			
# If COPY src ./ is mentioned then contents in side src directory will be copied and not src itself

COPY pom.xml ./
# In case of file as it is will be copied with same name as source file, we can mention COPY pom.xml ./pom.xml

RUN ["mvn", "clean","package","-DskipTests"]

FROM openjdk:8

WORKDIR /opt/apps/

COPY --from=builder /apps/target/psinventory.war ./psinventory.war
# We have to mention file name at destination location otherwise docker will extract war file and copy its content at destination 

ENTRYPOINT ["java","-jar","psinventory.war"]


