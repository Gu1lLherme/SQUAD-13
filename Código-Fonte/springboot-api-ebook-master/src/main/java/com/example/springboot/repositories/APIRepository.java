package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.APIModel;

import java.util.UUID;

//Código que facilita o acesso e manipulação de dados no banco de dados
@Repository
public interface APIRepository extends JpaRepository<APIModel, UUID>{

}
