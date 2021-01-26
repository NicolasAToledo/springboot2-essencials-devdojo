package br.com.fatecmc.springboot2.service;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//É como se fosse a classe responsavel pela regra de negocio (RN)
@Service
public class AnimeService  {
    //implements AnimeRepository
    //private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return List.of(new Anime( 1L,"Nanatsu"), new Anime(2L,"Naruto"));
    }
}
