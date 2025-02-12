package com.example.EsercizioBE_U2_W2_D2_BloggingApp.service;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.PostDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.repository.PostDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostDAORepository postRepo;

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Optional<Post> getPostById(long id) {
         Optional<Post> post = postRepo.findById(id);
         if(post.isPresent()) {
             return post;
         } else {
             throw new RuntimeException("Post non trovato nel DB");
         }
    }
    //travaso DTO
    public Post fromPostDTOToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setTitolo(postDTO.getTitolo());
        post.setCategoria(post.getCategoria());
        post.setAutore(postDTO.getAutore());
        post.setContenuto(postDTO.getContenuto());
        post.setTempoDiLettura(postDTO.getTempoDiLettura());
        return post;
    }

    public PostDTO fromPostToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitolo(post.getTitolo());
        postDTO.setAutore(post.getAutore());
        postDTO.setContenuto(post.getContenuto());
        postDTO.setTempoDiLettura(post.getTempoDiLettura());
        return postDTO;
    }


//vedi dopo
   /* public void addPost(PostDTO postDTO) {
        Post postEntity = fromPostDTOToEntity(postDTO);

    }*/

    public String addPost(Post post) {
        postRepo.save(post);
        return "Post con id: " + post.getId() + "salvato nel db";
    }

    public Post updatePostById(long id, Post post) {
        Post result = getPostById(id).get();
        result.setAutore(post.getAutore());
        result.setTitolo(post.getTitolo());
        result.setCategoria(post.getCategoria());
        result.setContenuto(post.getContenuto());
        result.setTempoDiLettura(post.getTempoDiLettura());
        return result;
    }
}
