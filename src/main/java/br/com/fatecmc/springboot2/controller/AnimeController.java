package br.com.fatecmc.springboot2.controller;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.service.AnimeService;
import br.com.fatecmc.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
//@AllArgsConstructor Cria um construtor com todos os campos
@RequiredArgsConstructor //Cria um construtor com os campos que são finais
public class AnimeController {

    //@Autowired
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    //localhost:8090/anime/list
    //@RequestMapping(method = RequestMethod.GET, path = "list")JEITO_ANTIGO

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findById(id));
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Anime anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }
}
