### Configure a PostgreSQL database

`src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/post_restful
spring.datasource.username=postgres
spring.datasource.password=postgres
```

#### List example

```bash
curl -X GET http://localhost:8080/posts
```

```java
@GetMapping
public List<Post> list() {
    return repository.findAll();
}
```

#### Retrieve example

```bash
curl -X GET http://localhost:8080/posts/<id>
```

```java
@GetMapping("/{id}")
public ResponseEntity<Post> retrieve(@PathVariable Long id) {
    return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
```

#### Post example

```bash
curl -X POST http://localhost:8080/posts \
     -H "Content-Type: application/json" \
     -d '{"title": "Title example", "content": "Content Example"}'
```

```java
@PostMapping
public Post create(@RequestBody Post post) {
    return repository.save(post);
}
```
