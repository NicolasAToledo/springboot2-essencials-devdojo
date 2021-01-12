package br.com.fatecmc.springboot2.controller;

import br.com.fatecmc.springboot2.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeController {
    //localhost:8090/anime/list
    //@RequestMapping(method = RequestMethod.GET, path = "list") JEITO ANTIGO
    @GetMapping(path = "list")
    public List<Anime> list(){
        return List.of(new Anime( "DBZ"), new Anime("Naruto"));
    }
}
