package com.example.cobadocker.repository;

import com.example.cobadocker.entity.Akun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AkunRepository extends JpaRepository<Akun, Integer>
{
    
}
