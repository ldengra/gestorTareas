package com.ldengra.gestorTareas.web;

import com.ldengra.gestorTareas.entity.TareaEntity;
import com.ldengra.gestorTareas.entity.UsuarioEntity;
import com.ldengra.gestorTareas.service.GestorTareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class GestorTareasController {

    @Autowired
    private GestorTareasService service;


    //TAREA
    @GetMapping("/getTarea/{id}")
    public ResponseEntity<TareaEntity> getTarea(@PathVariable Long id){

        TareaEntity tarea;

        tarea = service.getTarea(id);

        return ResponseEntity.ok().body(tarea);
    }

    @PostMapping("/postTarea")
    public ResponseEntity<Void> postTarea(@RequestBody TareaEntity tarea){

        service.postTarea(tarea);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/putTarea/{id}")
    public ResponseEntity<Void> putTarea(@PathVariable Long id, @RequestBody TareaEntity tarea){

        service.putTarea(id,tarea);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deleteTarea/{id}")
    @PutMapping("/putTarea/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id){

        service.deleteTarea(id);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //USUARIO
    @GetMapping("/getUsuario/{id}")
    public ResponseEntity<UsuarioEntity> getUsuario(@PathVariable Long id){

       UsuarioEntity usuario =  service.getUsuario(id);

        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/postUsuario")
    public ResponseEntity<Void> postUsuario(@RequestBody UsuarioEntity usuario){

        service.postUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/putUsuario")
    public ResponseEntity<Void> putUsuario(@RequestBody UsuarioEntity usuario){



        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //LISTADO TAREAS
    @GetMapping("/getListadoTareas")
    public ResponseEntity<List<TareaEntity>> getListaTareas(){

        List<TareaEntity> listaTareas = service.getListaTareas();


        return ResponseEntity.ok().body(listaTareas);
    }
}
