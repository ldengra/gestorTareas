package com.ldengra.gestorTareas.web;

import com.ldengra.gestorTareas.entity.TareaEntity;
import com.ldengra.gestorTareas.entity.UsuarioEntity;
import com.ldengra.gestorTareas.service.GestorTareasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("api")
public class GestorTareasController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GestorTareasController.class);
    @Autowired
    private GestorTareasService service;

    //TAREA
    @GetMapping("/getTarea/{id}")
    public ResponseEntity<TareaEntity> getTarea(@PathVariable Long id){

        List<String> errorParams = new ArrayList<>();
        if (Objects.isNull(id)){
            errorParams.add("id is null");
        }
        if (!errorParams.isEmpty()){
            return (ResponseEntity<TareaEntity>) ResponseEntity.badRequest();
        }

        TareaEntity tarea = null;
        try{
            tarea = service.getTarea(id);
        }catch (Exception e){
            LOGGER.error("El id no existe");
        }

        if (tarea == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(tarea);
        }
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
    public ResponseEntity<Void> putUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario){

        service.putUsuario(id,usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){

        service.deleteUsuario(id);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //LISTADO TAREAS
    @GetMapping("/getListadoTareas/{id}")
    public ResponseEntity<List<TareaEntity>> getListaTareas(@PathVariable Long id){

        List<TareaEntity> listaTareas = service.getListaTareas(id);


        return ResponseEntity.ok().body(listaTareas);
    }


}
