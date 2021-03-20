package com.example.cobadocker;

import com.example.cobadocker.entity.Akun;
import com.example.cobadocker.repository.AkunRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CobaDockerApplication implements CommandLineRunner
{
	@Autowired
	AkunRepository akunRepository;

	public static void main(String[] args) {
		SpringApplication.run(CobaDockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Akun akun = akunRepository.save(new Akun("Akun 1"));
		akunRepository.deleteById(akun.getId());
	}

}
