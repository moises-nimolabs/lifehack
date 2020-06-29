<# 
    Bring up the Builders
    just in case you want to keep them up and running in case you want to rebuild the project
    wait it to finish before going further with the builders
#>
docker-compose build
docker-compose up -d maven netcore angular-cli



# build all applications
docker-compose exec maven mvn clean install deploy  
docker-compose exec netcore dotnet build
docker-compose exec netcore dotnet publish
docker-compose exec angular-cli npm run-script dist
