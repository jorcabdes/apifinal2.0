package org.example.apifinal.auth;

import org.example.apifinal.modelo.Comentario;
import org.example.apifinal.modelo.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Service
public class ComentarioService {

        @Autowired
        private ComentarioRepository comentarioRepository;

        /*public DepartamentoService(DepartamentoRepository departamentoRepository) {
            this.departamentoRepository = departamentoRepository;
        }*/
        public List<Comentario> procearCSV(MultipartFile file) {

            List<Comentario> comentarios = new ArrayList<>();
            try(InputStream is = file.getInputStream()){
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                br.lines()
                        .map(l -> {
                            String[] datos = l.split(",");
                            return Comentario.builder()
                                .titulo(datos[0].trim()) // Primera columna
                                .contenido(datos.length > 1 ? datos[1].trim() : "")
                                .build();
                        }).forEach(a -> comentarios.add(a));

                return comentarioRepository.saveAll(comentarios);

            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        public List<Comentario> getAll() {
            return comentarioRepository.findAll();
        }
        public Comentario add(Comentario comentario) {
            return comentarioRepository.save(comentario);
        }
        public Comentario update(Comentario comentario) {
            return comentarioRepository.save(comentario);
        }
        public Comentario delete(Long id) throws Throwable{
            Comentario comentario = comentarioRepository
                    .findById(id)
                    .orElseThrow();
            comentarioRepository.delete(comentario);
            return comentario;
        }
}
