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