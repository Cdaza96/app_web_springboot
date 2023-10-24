/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daza.christian.app_web_springboot;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Andres
 */
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String email;
    private LocalDateTime fechaRegistro;


    //obtener fecha de creacion
    @PrePersist
    private void loadDateCreate(){
        fechaRegistro = LocalDateTime.now();
    }
    
}


