package br.com.fatecmc.springboot2.repository;

import br.com.fatecmc.springboot2.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository {
    List<Anime> listAll();
}
