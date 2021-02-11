package br.com.fatecmc.springboot2.mapper;

import br.com.fatecmc.springboot2.domain.Anime;
import br.com.fatecmc.springboot2.domain.Anime.AnimeBuilder;
import br.com.fatecmc.springboot2.requests.AnimePostRequestBody;
import br.com.fatecmc.springboot2.requests.AnimePutRequestBody;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-11T17:33:23-0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class AnimeMapperImpl extends AnimeMapper {

    @Override
    public Anime toAnime(AnimePostRequestBody animePostRequestBody) {
        if ( animePostRequestBody == null ) {
            return null;
        }

        AnimeBuilder anime = Anime.builder();

        anime.name( animePostRequestBody.getName() );

        return anime.build();
    }

    @Override
    public Anime toAnime(AnimePutRequestBody animePutRequestBody) {
        if ( animePutRequestBody == null ) {
            return null;
        }

        AnimeBuilder anime = Anime.builder();

        anime.id( animePutRequestBody.getId() );
        anime.name( animePutRequestBody.getName() );

        return anime.build();
    }
}
