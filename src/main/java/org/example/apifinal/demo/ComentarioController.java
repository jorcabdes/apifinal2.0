package org.example.apifinal.demo;

import org.example.apifinal.auth.ComentarioService;
import org.example.apifinal.modelo.Comentario;
import org.example.apifinal.modelo.Result;
import org.example.apifinal.user.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    Logger logger = LoggerFactory.getLogger(ComentarioController.class.getName());

    @GetMapping(value = "get")
    private ResponseEntity<?> findAll() {
        return ResponseEntity.ok(comentarioService.getAll());
    }

    @PostMapping(value = "post")
    private ResponseEntity<?> addUser(@RequestBody Comentario departamento) {
        return ResponseEntity.ok(comentarioService.add(departamento));
    }
    @PutMapping(value = "put")
    private ResponseEntity<?> updateUser(@RequestBody Comentario departamento) {
        return ResponseEntity.ok(comentarioService.update(departamento));
    }
    @DeleteMapping("delete/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

        try {
            return ResponseEntity.ok(new Result.Sucess<>(comentarioService.delete(id)));
        }catch (Exception e) {
            return ResponseEntity.ok(new Result.Error(e.getMessage()));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipart) {
        logger.info("Recibida peticion procesar CSV");

        return ResponseEntity.ok(comentarioService.procearCSV(multipart));

    }
}
