package br.com.fatecmc.springboot2.service;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.mapper.AnimeMapper;
import br.com.fatecmc.springboot2.repository.AnimeRepository;
import br.com.fatecmc.springboot2.requests.AnimePostRequestBody;
import br.com.fatecmc.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//É como se fosse a classe responsavel pela regra de negocio (RN)
@Service
@RequiredArgsConstructor
public class AnimeService  {


    //implements AnimeRepository
    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody){
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime animeSaved = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(animeSaved.getId());
        animeRepository.save(anime);
    }
}
