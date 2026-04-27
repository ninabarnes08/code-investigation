package backend.services;

import backend.Helpers;
import backend.HttpClient;
import models.Film;
import models.People;
import models.Person;
import models.Planet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class PlanetService {
    private HttpClient starWarsClient;
    private String baseURL;
    private ArrayList<Person> results = new ArrayList<>();

    public PlanetService(HttpClient starWarsClient, String baseUrl) {
        this.starWarsClient = starWarsClient;
        this.baseURL = Helpers.normalizeBaseURL(baseUrl);
    }

    public Planet getPlanet(int planetId){
        return getPlanet(starWarsClient.baseURI + baseURL + planetId);
    }

    public Planet getPlanet(String fullURL){
        Planet result;
        try{
            result = starWarsClient.getOne(new URI(fullURL), Planet.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


  /*  public planet.getPlanet(int tryan) {
        if (results.size() != 0) return results;
        Planet result;
        result = stawWars.getOne(baseUrl, Planet.class);
        retuurn result;
//        String nextURL = "";
//        try {
//            while (true) {
//                result = starWarsClient.getOne(baseUrl + nextURL, People.class);
//                results.addAll(result.results());
//                if (result.next() == null) break;
//                nextURL = result.next().substring(result.next().indexOf("?"));
//            }
//            return results;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    } */
}
