package com.example.msalmacen.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materiales", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tipo", "nombre", "color"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;         // tela, hilo, cremallera, botón, etc.
    private String nombre;       // nombre del material (tela poliéster, hilo de algodón, etc.)
    private String color;        // rojo, azul, blanco
    private String medida;       // metros, unidades, gramos
    private Double cantidad;     // 10.5 metros, 50 unidades, etc.
    private Double costoUnitario;
    private String proveedor;

    // Por ejemplo: tipo="tela", nombre="poliester", color="azul" sería único
}
