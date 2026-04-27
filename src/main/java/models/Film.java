package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record Film(
        String title,
        @JsonProperty("episode_id")
        int episodeId,
        String opening_crawl,
        String director,
        String producer,
        @JsonProperty("release_date")
        String releaseDate,
        List<String> characters,
        List<String> planets,
        List<String> starships,
        List<String> vehicles,
        List<String> species,
        String created,
        String edited,
        String url
){}