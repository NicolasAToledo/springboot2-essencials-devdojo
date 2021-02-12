package br.com.fatecmc.springboot2.service;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.exception.BadRequestException;
import br.com.fatecmc.springboot2.mapper.AnimeMapper;
import br.com.fatecmc.springboot2.repository.AnimeRepository;
import br.com.fatecmc.springboot2.requests.AnimePostRequestBody;
import br.com.fatecmc.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//É como se fosse a class responsavel pela regra de negocio (RN)
@Service
@RequiredArgsConstructor
public class AnimeService  {


    //implements AnimeRepository
    private final AnimeRepository animeRepository;
    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    @Transactional
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
