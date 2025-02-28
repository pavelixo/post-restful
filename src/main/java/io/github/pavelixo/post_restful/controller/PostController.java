package io.github.pavelixo.post_restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.pavelixo.post_restful.repository.PostRepository;
import io.github.pavelixo.post_restful.model.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
	private final PostRepository repository;

	public PostController(PostRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Post> list() {
		return repository.findAll();
	}

	@PostMapping
	public Post create(@RequestBody Post post) {
		return repository.save(post);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> retrieve(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
