# movie-sv

* **Version:** 0.0.1-SNAPSHOT
* **Description:** Service for managing movies

## REST Endpoints

### /swagger-ui/index.html

* **GET**

### /videoclub

* **POST:**

  Url: /videoclub/movie
    
  Consume: application/json
    
```json
   {
     "imdbId": "1234567890",
     "name": "Star Wars",
     "stock": "25"
   }
```

  Produce: application/json

```json
   {
     "id": "62fc96faced333564842f302",
     "imdbId": "1234567890",
     "name": "Star Wars",
     "stock": "25"
   }
```

## Mongo Data persistence

**Database:** videoclub

* **Collection:** movies (collection to store movies)

## Event Consumer

* **Topic:** videoclub-user-validated (event message to communicate the user validation)

## Event Producer

* **Topic:** videoclub-movie-reserved (event message to communicate the movie reservation)
* **Topic:** videoclub-movie-rejected (event message to communicate issues with the movie reservation)