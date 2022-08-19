# booking-sv

* **Version:** 0.0.1-SNAPSHOT
* **Description:** Service for managing booking

## REST Endpoints

### /videoclub

* **POST:**

  Url: /videoclub/booking
    
  Consume: application/json
    
```json
   {
     "imdbId": "1234567890",
     "userId": "62fe1a48df883b786b2eaf0"
   }
```

  Produce: application/json

```json
   {
     "id": "62ff3faa292e927ce9f7022e",
     "imdbId": "1234567890",
     "userId": "62fe1a48df883b786b2eaf0",
     "status": "CREATED",
     "lastUpdateDatetime": "2022-08-19 07:45:46"
   }
```

## Mongo Data persistence

**Database:** videoclub

* **Collection:** booking (collection to store bookings)
