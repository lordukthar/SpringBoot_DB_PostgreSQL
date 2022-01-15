This is a set up of Spring Boot and PostgreSQL. Done loacally on a Mac.
Java 17
Postgres 13
Also used pgAdmin

Created repo locally and pushed it, followed these instructions
https://docs.github.com/en/github/importing-your-projects-to-github/importing-source-code-to-github/adding-an-existing-project-to-github-using-the-command-line

git init -b main

git add .

git commit -m "First commit"

git remote add origin https://github.com/lordukthar/SpringBoot_DB_PostgreSQL.git

git remote -v

git push -u origin main


##Just a test of request commit

GET http://localhost:9090/test_commit

curl -v http://localhost:9090/test_commit


##All playgrounds

GET http://localhost:9090/playgrounds

curl -v http://localhost:9090/playgrounds

##BY ID (try 1 for instance)

GET http://localhost:9090/playgrounds/1

curl -v http://localhost:9090/playgrounds/1

##POST JSON

http://localhost:9090/playgrounds/
{
  "color": "red"
}

curl  -d '{"color":"lightgrey"}' -X POST http://localhost:9090/playgrounds/ -H "Content-Type: application/json"

##Test this

Set
 @Transactional(readOnly = true) in PlaygroundService row 37 
 
 POST gives you
 {
   "timestamp": "2022-01-15T14:43:44.342+00:00",
   "status": 500,
   "error": "Internal Server Error",
   "path": "/playgrounds/"
 }

 
 change to false, not it works



