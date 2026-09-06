# springboot-data-redis-cache

[![Java CI with Maven](https://github.com/hendisantika/springboot-data-redis-cache/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/springboot-data-redis-cache/actions/workflows/maven.yml)

## Introduction

REmote DIctionary Server (Redis) is an in-memory data structure store. It can be used as a simple database,
a message broker and for caching through its support for various data structures.

This demo project shows how to use Redis with Spring Boot for:
- storing and retrieving data with `RedisTemplate` (see `ProductDao`, `UserRepository`)
- method-level caching with `@Cacheable`/`@CacheEvict` (see `ProductController`)
- a custom `CacheResolver` that assigns a different TTL per cache name (see `CustomCacheResolver`, `CacheService`)

## Tech Stack

- Java 21
- Spring Boot 4.1.1 (Web, Data Redis)
- Jedis 8 (Redis client)
- Lombok
- Maven

## Prerequisites

- JDK 21+
- Maven (or use the bundled `./mvnw`)
- A running Redis instance

## Running Redis locally

A `compose.yml` is provided to run a local Redis instance with Docker:

```bash
docker compose up -d
```

This starts `redis/redis-stack` on `localhost:6379`.

## Configuration

Redis connection details are read from environment variables (see `src/main/resources/application.properties`),
with safe local defaults so the app runs out of the box against a local, unauthenticated Redis:

| Environment variable | Default     | Description       |
|-----------------------|-------------|--------------------|
| `REDIS_HOST`          | `localhost` | Redis host         |
| `REDIS_USERNAME`      | `default`   | Redis ACL username |
| `REDIS_PASSWORD`      | *(empty)*   | Redis password     |

To point the app at a remote/managed Redis instance (e.g. Upstash, Redis Cloud), export the variables before
starting the app instead of hardcoding them:

```bash
export REDIS_HOST=your-redis-host
export REDIS_USERNAME=your-username
export REDIS_PASSWORD=your-password
```

## Running the application

1. Clone this repository: `git clone https://github.com/hendisantika/springboot-data-redis-cache.git`
2. Go inside the folder: `cd springboot-data-redis-cache`
3. Start Redis: `docker compose up -d`
4. Run the application: `./mvnw spring-boot:run`

On startup, `DataSeeder` populates a handful of sample `Product` entries into Redis (this seeder is skipped
under the `test` profile, so tests don't depend on a live Redis connection).

## API Endpoints

| Method | Path                    | Description                              |
|--------|-------------------------|-------------------------------------------|
| POST   | `/product`               | Save a product                            |
| GET    | `/product`                | List all products                         |
| GET    | `/product/{id}`           | Get a product by id (cached)              |
| DELETE | `/product/{id}`           | Delete a product by id (evicts cache)     |
| GET    | `/get/data`                | Cached sample data (default TTL)          |
| GET    | `/get/datattl/10`          | Cached sample data (10 minute TTL)         |
| GET    | `/get/datattl/20`          | Cached sample data (20 minute TTL)         |

## Running tests

```bash
./mvnw test
```

## Continuous Integration

Every push and pull request against `master` is built with Maven on JDK 21 via GitHub Actions
(see `.github/workflows/maven.yml`).
