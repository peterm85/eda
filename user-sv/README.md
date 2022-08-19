# user-sv

* **Version:** 0.0.1-SNAPSHOT
* **Description:** Service for managing users

## REST Endpoints

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
