1°:
Acesse o src/main/resources/application.properties e insira a url, username e password do banco de dados a ser utilizado.

2°:
Acesse o arquivo APIBackendCenconcud na pasta src/main/java/com/cenconsud/api_backend_cenconsud e, em seguida, inicie o projeto.

3°:
Acesse esta url para verificar o relatório dos métodos CRUD do projeto: http://localhost:8080/swagger-ui.html

4°:
Insira estas urls no postman, ou outro gerenciador de desenvolvimento de API,
para interagir com o banco de dados cadastrado anteriormente.

POST: "http://localhost:8080/products"
GET:"http://localhost:8080/products/{id}"
GET ALL:"http://localhost:8080/all/products"
PUT: "http://localhost:8080/products/{id}"
DELETE:"http://localhost:8080/products/{id}"