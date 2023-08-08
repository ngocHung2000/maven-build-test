# Hi there!
> In my project, we want to use Dockerfile to build project and deploy maven project with Jenkinsfile
> Now right here!
### You can to test when you run file like:
```
docker compose up -d
```
#### Get all
```
curl -X GET http://localhost:8080/api/product
```
#### Search by Id
```
curl -X GET http://localhost:8080/api/product/search/1
```
#### Search by name
```
curl -X GET http://localhost:8080/api/product/search/name/e
```
#### Create product
```
curl -X POST -H "Content-Type: application/json" \
-d '{"id":99,"nameProduct":"Keo bong gon","price":12000.00,"description":"Keo bong gon"}' \
http://localhost:8080/api/product/create
```

#### Update product
```
curl -X PUT -H "Content-Type: application/json" \
-d '{"id":2,"nameProduct":"Keo bong gon","price":12000.00,"description":"Keo bong gon"}' \
http://localhost:8080/api/product/update/2
```
#### Delete product
curl -X DELETE http://localhost:8080/api/product/delete/1