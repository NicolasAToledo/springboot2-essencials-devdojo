package br.com.fatecmc.springboot2.controller;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.requests.AnimePostRequestBody;
import br.com.fatecmc.springboot2.requests.AnimePutRequestBody;
import br.com.fatecmc.springboot2.service.AnimeService;
import br.com.fatecmc.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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
        return ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>> findByName(@RequestParam String name){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findByName(name));
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody animePostRequestBody){
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //OU return ResponseEntity.ok<>(animeService.listAll());
    }
}
