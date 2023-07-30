package com.ldengra.gestorTareas.repository;

import com.ldengra.gestorTareas.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareaRepository extends JpaRepository<TareaEntity,Long> {


    @Query(value = "SELECT t.*" +
            " FROM TAREA t JOIN USUARIO u " +
            " ON t.usuario_id = u.id " +
            " WHERE u.id = :idUser", nativeQuery = true)
    public List<TareaEntity> findAllByUser(@Param("idUser")Long idUser);
}

