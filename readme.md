# LifeHack Project 
This is a simple project to test user choices in order to reach a spcific goal at the end of the questions.  
* Each question has two possible answers  
* Each answer opens up a question with two new questions  
* At the end of the process the User should know which path he chosen  
* The system should `persist` the user choices  

# Introduction, Architectural Decisions and Technologies  
## Neo4J as Database  
`Project: LifeHack.Database`  
I've chosen Neo4J as the base project database because of it's unique GraphQL feature to allow for easy query 
of objects with simple mechanims, making it easier to provide node relationships faster than conventional RDBS.  

## Data Access Layer  
`Project: LifeHack.Data`  
I've chosen Java Spring Boot as base project for the Data Access Layer, once it's Neo4J integration is 
production ready, and community support is widely adopted.  
Although there is a .Net alternative, it's only compatible with .Net Standard Framework, hence making it impossible to 
fetch data in stable/production ready environments. 

## Api Layer  
`Project: LifeHack`  
The main Api is coded using C# .Net using .Net Core 2.2, due it's compatibility with code once/run everywhere approach, 
making it possible to generate micro service architecture easily. 

## Web UI Layer  
`ProjecT: LifeHacUI`  
The main User Interface is coded using `@angular/cli` due to it's future-proof, enginer/user friendly architecture, 
making it possible to generate compressed applications with minimal file sizes transpiled using WebPack.  

# Containerization  
The application is fully containerized, making it possible to be executed in `Docker`, hence allowing for 
easier scalability either through `Docker Swarm` or `Kubernetes`.  
It's strongly recommended the you fetch the whole project inside a folder that `Docker` has access.  
Usually I recommend using the `$HOME` directory as the root. Of course you can use any directory, but 
beware that `Docker` might complain about access restrictions upon reading/writing files in the application structure.  


# Building the Base Images and Containers  
`Before you start, make sure you know where your docker-machine is running. 
Make sure you have it's ip address noted somewhere, or known by heart. 
I usually develop using a Raspberry PI with a remote docker-machine, which means all the IP addresses used in this project are pointing to the default docker-machine ip address.`  

## Docker Configuration Check-Up and Application Settings  

To check what is your `docker-machine` ip, issue the following command:
```
docker-machine ip
```

If you use `Docker Toolbox`, the IP address will be most likely `192.168.99.100`.  
If you use `Docker for Windows` or any `Docker Appliance`, it'll expose the `localhost[127.0.0.1]` as default `docker-machine` endpoint.

`Once you know the docker-machine ip address`, please update all application settings to reflect the `docker-machine ip`.  
By default, this project uses `192.168.99.100` as default IP address for all the configurations.  
The application settings are enlisted below:  
`Please make sure to replace the ip 192.168.99.100 for your docker-machine ip`  
* LifeHack/LifeHack.Api/appsettings.Development.json  
* LifeHack.Data/src/main/resources/application.properties  
* LifeHackUI/src/environments/environment.prod.ts  

## Build all applications Using Docker
Òpen any shell app in the root solution folder to follow this whole section.
```
docker-compose build`
```

One by one I suggest them to be built using `Docker` to avoid conflicts with platform binaries.  
With the run command we need to make sure to remove the `containers` used to perform the `run` tasks.  
By using a `shell`, browse to the

```
docker-compose run --rm maven mvn clean install deploy  
docker-compose run --rm netcore dotnet publish
docker-compose run --rm node npm install --no-bin-links
docker-compose run --rm node npm install -g @angular/cli --no-bin-links
docker-compose run --rm node npm run-script dist --no-bin-links
```

## Clean up unused containers  
This will save extra space on your system in case docker complains.  
```
docker container prune
```

## Running the Database  
Before you start, I strongly recommend you to perform the initial `Database Setup` prior the application execution.  
It'll make it easier and avoid unintended crashes throughout all the applications developed in this solution. To do that, issue the following command:

```
docker-compose up -d db
```

The `db` container should be available at the address: `http://192.168.99.100:7474`. 
Use the following credentials:  
* bolt: `bolt://192.168.99.100:7687`  
* user: `neo4j`  
* pass: `@abc123`  

Copy the text from `LifeHack.Database/app.data.cypher` and paste in the `Cypher Query Runner` and click play.  
You should be able to see the results by running a simple query in the `Cypher Query Runner`:  
```
match(n) return n
```  

You should be able to see all the application pre-configured nodes bouncing around the screen.  

`Since the DB is an important aspect of this proof of concept, you should have it always running, even when you are using local development using your favourite IDE. ` 

## Running the Applications  
I suggest that you load the applications only when the `Database` is fully loaded.  

### Data Layer  
Now it's time to run the Data Layer Application.  
You can also run this one easily by issuing the command:  
```
docker-compose up -d data-api
```  
I strongly suggest you to wait it finish loading before you go to the next application.  
It can be easily accessed via `http://192.168.99.100:8080/goal/`.  
If it's loaded successfully you will see a series of Nodes in the `JSON` format.  

### Api Layer  
The api layer is supposed to connect to the `Data Layer` via http. To run it, issue the command:
```
docker-compose up -d api
```
When it's fully loaded you can see the results on the endpoint `http://192.168.99.100:8000/api/goals`.  

### Web Layer  
This is the Angular CLI client application. It's supposed to connect to the Api Layer via http.  
To run it, issue the command:
```
docker-compose up -d web
```

The user interactions can be done by clicking on the questions provided by the front-end, allowing for the user to see his life path through a series of questions/answers.

