package br.com.fatecmc.springboot2.controller;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
//@AllArgsConstructor Cria um construtor com todos os campos
@RequiredArgsConstructor //Cria um construtor com os campos que são finais
public class AnimeController {

    //@Autowired
    private final DateUtil dateUtil;

    //localhost:8090/anime/list
    //@RequestMapping(method = RequestMethod.GET, path = "list")JEITO_ANTIGO
    @GetMapping(path = "list")
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime( "DBZ"), new Anime("Naruto"));
    }
}
