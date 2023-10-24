package daza.christian.app_web_springboot;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private LocalDateTime fechaVencimiento;


    @PrePersist
    private void loadDateCreate(){
        fechaVencimiento = LocalDateTime.now();
    }
}
