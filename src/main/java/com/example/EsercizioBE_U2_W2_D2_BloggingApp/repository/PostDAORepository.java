package com.example.EsercizioBE_U2_W2_D2_BloggingApp.repository;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAORepository extends JpaRepository<Post, Long> {
}
