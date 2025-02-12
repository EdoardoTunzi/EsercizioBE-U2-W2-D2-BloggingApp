package com.example.EsercizioBE_U2_W2_D2_BloggingApp.controller;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.PostDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogPosts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }

   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String newPost(@RequestBody PostDTO postDTO) {
       postService.addPost(postDTO);
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void newPost(@RequestBody Post post) {
        postService.addPost(post);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
        return postService.updatePostById(id,post);

    }

    @DeleteMapping("/{id}")
    public String updatePost(@PathVariable int id) {
        postService.deletePostById(id);
        return "Post con id " + id + "eliminato con successo";
    }


}
