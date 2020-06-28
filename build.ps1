# build all images
docker-compose build

# build all applications
docker-compose run build-data mvn clean install deploy  
docker-compose run build-api dotnet build
docker-compose run build-api dotnet publish
docker-compose run build-web npm run-script dist
