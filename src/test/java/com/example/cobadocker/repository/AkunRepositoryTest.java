package com.example.cobadocker.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.cobadocker.entity.Akun;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AkunRepositoryTest 
{
    @Autowired
    AkunRepository akunRepository;

    @BeforeEach
    void init()
    {
        akunRepository.save(new Akun("Ariana"));
        akunRepository.save(new Akun("Beatrice"));
        akunRepository.save(new Akun("Caroline"));
    }

    @AfterEach
    void destroy()
    {
        akunRepository.deleteAll();
    }

    @Test
    void count()
    {
        assertEquals(3, akunRepository.count());
    }
    
}
