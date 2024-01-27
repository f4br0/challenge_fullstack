# challenge_fullstack

application for search item speedly

```
reto-app
├── domain
│   ├── model
│   │   ├── Entity1.java
│   │   └── Entity2.java
│   ├── usecase
│   │   ├── UseCase1.java
│   │   └── UseCase2.java
│   └── port
│       ├── Port1.java
│       └── Port2.java
├── application
│   ├── service
│   │   ├── Service1.java
│   │   └── Service2.java
│   └── dto
│       ├── Dto1.java
│       └── Dto2.java
└── infrastructure
    ├── adapter
    │   ├── Adapter1.java
    │   └── Adapter2.java
    ├── repository
    │   ├── Repository1.java
    │   └── Repository2.java
    └── controller
        ├── Controller1.java
        └── Controller2.java
```

* domain: Este paquete contiene las clases que representan los conceptos centrales de tu negocio. Aquí es donde se definen las entidades y los casos de uso.

* application: Este paquete contiene la lógica de la aplicación que orquesta el flujo de datos entre la capa de dominio y la capa de infraestructura.

* infrastructure: Este paquete contiene todo el código que interactúa con sistemas externos, como bases de datos, servicios web, etc.
  This endpoint makes an HTTP GET request to retrieve items based on a search query and a limit parameter. The "search" parameter is used to specify the search term, and the "limit" parameter is used to limit the number of items returned in the response.

## API item
[Reto API documentation v.1 swagger](http://localhost:8080/swagger-ui.html)
### Get items by coincident name and limit X
```curl
curl --location 'http://localhost:8080/api/item?search=item&limit=4'
```
response
```json
[
    {
        "id": 1,
        "name": "Item 1"
    },
    {
        "id": 2,
        "name": "Item 2"
    },
    {
        "id": 3,
        "name": "Item 3"
    },
    {
        "id": 4,
        "name": "Item 4"
    }
]
```

The last execution of this request returned a 200 status code with a JSON response containing an array of objects. Each object in the array represents an item and includes an "id" and "name" field.

### Get item by id
this endpoint makes an HTTP GET request to retrieve an item based on an id parameter. The "id" parameter is used to specify the id of the item to retrieve.
```curl
curl --location 'http://localhost:8080/api/item/4'
```
response
```json
{
  "id": 4,
  "name": "Item 4",
  "description": "Description item 4 este item 4 es muy bueno lalalalala"
}
```
