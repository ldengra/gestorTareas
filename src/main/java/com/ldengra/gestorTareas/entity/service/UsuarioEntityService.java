package com.ldengra.gestorTareas.entity.service;

import com.ldengra.gestorTareas.entity.TareaEntity;
import com.ldengra.gestorTareas.entity.UsuarioEntity;
import com.ldengra.gestorTareas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioEntityService {

    private final UsuarioRepository repository;

    public UsuarioEntity findById(Long id){
        Optional<UsuarioEntity> optionalUsuario =repository.findById(id);


        return optionalUsuario.orElseThrow(() -> new NoSuchElementException("La tarea con el ID " + id + " no existe"));
    }

    public void save(UsuarioEntity usuario){
        try{
            repository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
