package com.example.cobadocker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Akun 
{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    public Akun(String name) {
        this.name = name;
    }

}
