package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crud.model.Post;

public interface PostRepository extends JpaRepository<Post ,Long  >{

}