package com.ldengra.gestorTareas.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TAREA")
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO")
    private String title;

    @Column(name = "DESCRIPCION")
    private String description;

    @Column(name = "FECHA_LIMITE")
    private String dueDate;

    @Column(name = "PRIORIDAD")
    private String priority;

    @Column(name = "ESTADO")
    private String status;

    @Column(name = "ASIGNADO")
    private String assignee;
}
