package com.example.EsercizioBE_U2_W2_D2_BloggingApp.repository;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreDAORepository extends JpaRepository<Autore, Long> {
}
