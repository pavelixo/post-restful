package io.github.pavelixo.post_restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pavelixo.post_restful.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {}
