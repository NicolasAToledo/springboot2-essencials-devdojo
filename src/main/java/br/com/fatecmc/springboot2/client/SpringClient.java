package br.com.fatecmc.springboot2.client;

import br.com.fatecmc.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> forEntity = new RestTemplate().getForEntity("http://localhost:8090/animes/{id}", Anime.class, 2);
        log.info(forEntity);

        Anime forObject = new RestTemplate().getForObject("http://localhost:8090/animes/{id}", Anime.class, 2);
        log.info(forObject);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8090/animes/all", Anime[].class);
        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> exchange =
                new RestTemplate().exchange("http://localhost:8090/animes/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Anime>>() {
        });
        log.info(exchange.getBody());
    }
}
