package br.com.fatecmc.springboot2.service;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//É como se fosse a classe responsavel pela regra de negocio (RN)
@Service
public class AnimeService  {

    private List<Anime> animes = List.of(new Anime( 1L,"Nanatsu"), new Anime(2L,"Naruto"));
    //implements AnimeRepository
    //private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }
}
