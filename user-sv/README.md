# user-sv

* **Version:** 0.0.1-SNAPSHOT
* **Description:** Service for managing users

## REST Endpoints

### /swagger-ui/index.html

* **GET**

### /videoclub

* **POST:**

  Url: /videoclub/user
    
  Consume: application/json
    
```json
   {
     "name":"Pedro",
     "address": "Valdelasfuentes street, 13th",
     "age":"25"
   }
```

  Produce: application/json

```json
   {
     "id": "62fe1a48df883b786b2eaf08",
     "name": "Pedro",
     "address": "Valdelasfuentes street, 13th",
     "age": 25
   }
```

## Mongo Data persistence

**Database:** videoclub

* **Collection:** users (collection to store users)

## Event Consumer

* **Topic:** videoclub-bookings-created (event message to communicate the booking creation)

## Event Producer

* **Topic:** videoclub-user-validated (event message to communicate the user validation)
* **Topic:** videoclub-user-invalidated (event message to communicate issues with the user validation)