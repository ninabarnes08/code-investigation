package models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public record Planet(
        String name,
        @JsonProperty("rotation_period")
        String rotationPeriod,

        @JsonProperty("orbital_period")
        String orbitalPeriod,
        long diameter,
        String climate,
        String gravity,
        String terrain,
//if you need any date methods you have them uright esy;
        @JsonProperty("surface_water")
        String surfaceWater,
        String population,
        List<String> residents,
        List<String> films,
        String created,
        String edited,
        String url
) {
}
