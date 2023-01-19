package com.crud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.dto.PostDTO;
import com.crud.crud.model.Post;
import com.crud.crud.repository.PostRepository;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostRepository repository;

    @PostMapping
    public void createPost(@RequestBody PostDTO req){
        repository.save(new Post(req));

    }

    @GetMapping
    public List<Post> listPosts(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletePost( @PathVariable Long id){
       
        repository.deleteById(id);

    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id ,@RequestBody PostDTO req){
        repository.findById(id).map(post ->{
            post.setImageURL(req.imageURL());
            post.setDescription(req.description());
            post.setLikes(req.likes());


            return repository.save(post);

        });

    }
    
}
