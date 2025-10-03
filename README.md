# BookMyShow - Spring Boot Application

A simplified BookMyShow clone built with Spring Boot, Hibernate, and PostgreSQL for interview preparation.

## Features

- Movie management (CRUD operations)
- Theater and screen management
- Show scheduling
- Seat booking system
- Customer booking management
- RESTful APIs for all operations

## Tech Stack

- **Backend**: Spring Boot 3.2.2
- **Database**: PostgreSQL
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Java Version**: 17

## Database Schema

The application includes the following entities:
- **Movie**: Movie details (title, genre, language, duration, etc.)
- **Theater**: Theater information (name, address, city)
- **Screen**: Theater screens with seat capacity
- **Seat**: Individual seats with types (REGULAR, PREMIUM, VIP)
- **Show**: Movie shows with timing and pricing
- **Booking**: Customer bookings
- **BookingSeat**: Junction table for booking-seat relationship

## Prerequisites

1. Java 17 or higher
2. Maven 3.6+
3. PostgreSQL 12+

## Setup Instructions

### 1. Database Setup

Create a PostgreSQL database:
```sql
CREATE DATABASE bookmyshow;
```

### 2. Application Configuration

Update `src/main/resources/application.yml` with your database credentials:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bookmyshow
    username: your_username
    password: your_password
```

### 3. Run the Application

```bash
# Clone the repository
git clone <repository-url>
cd bookmyshow

# Build and run
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Movies
- `GET /api/movies` - Get all movies
- `GET /api/movies/{id}` - Get movie by ID
- `POST /api/movies` - Create new movie
- `PUT /api/movies/{id}` - Update movie
- `DELETE /api/movies/{id}` - Delete movie
- `GET /api/movies/search?title={title}` - Search movies by title
- `GET /api/movies/genre/{genre}` - Get movies by genre
- `GET /api/movies/language/{language}` - Get movies by language

### Shows
- `GET /api/shows` - Get all shows
- `GET /api/shows/{id}` - Get show by ID
- `POST /api/shows` - Create new show
- `GET /api/shows/movie/{movieId}` - Get shows by movie
- `GET /api/shows/movie/{movieId}/city/{city}` - Get shows by movie and city
- `GET /api/shows/{id}/available-seats` - Get available seats for a show

### Bookings
- `POST /api/bookings` - Create new booking
- `GET /api/bookings/{id}` - Get booking by ID
- `GET /api/bookings/email/{email}` - Get bookings by customer email
- `GET /api/bookings/phone/{phone}` - Get bookings by customer phone
- `PUT /api/bookings/{id}/cancel` - Cancel booking

## Sample API Requests

### Create a Movie
```json
POST /api/movies
{
    "title": "Inception",
    "description": "A thief who steals corporate secrets through dream-sharing technology",
    "duration": 148,
    "genre": "Sci-Fi",
    "language": "English",
    "releaseDate": "2010-07-16"
}
```

### Create a Booking
```json
POST /api/bookings
{
    "customerName": "John Doe",
    "customerEmail": "john@example.com",
    "customerPhone": "9876543210",
    "showId": 1,
    "seatIds": [1, 2, 3]
}
```

## Sample Data

The application comes with pre-loaded sample data including:
- 5 popular movies (Avengers, RRR, Batman, etc.)
- 5 theaters across Bangalore and Mumbai
- Multiple screens and shows
- 100 seats for the first screen with different seat types

## Interview Topics Covered

This project demonstrates:
- **Spring Boot**: Auto-configuration, dependency injection
- **JPA/Hibernate**: Entity relationships, custom queries
- **REST APIs**: CRUD operations, proper HTTP status codes
- **Database Design**: Normalized schema, foreign keys
- **Transaction Management**: @Transactional annotation
- **Validation**: Bean validation with annotations
- **Exception Handling**: Custom error responses
- **Repository Pattern**: Data access layer abstraction

## Common Interview Questions

1. **How would you handle concurrent booking requests?**
   - Use database transactions and optimistic/pessimistic locking

2. **How to scale this application?**
   - Database sharding, caching (Redis), load balancing, microservices

3. **How to handle seat availability in real-time?**
   - WebSocket connections, event-driven architecture

4. **Database optimization strategies?**
   - Indexing, query optimization, connection pooling

## Next Steps for Enhancement

- Add authentication and authorization
- Implement caching with Redis
- Add payment integration
- Real-time seat availability updates
- Email/SMS notifications
- Admin dashboard
- Performance monitoring

## Testing

Run tests with:
```bash
mvn test
```

## Contributing

This is a learning project for interview preparation. Feel free to fork and enhance!
