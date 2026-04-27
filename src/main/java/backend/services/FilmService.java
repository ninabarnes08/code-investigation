package backend.services;

import backend.Helpers;
import backend.HttpClient;
import models.Film;
import models.FilmPage;

import java.io.IOException;
import java.util.ArrayList;

public class FilmService {
    HttpClient starWarsClient;
    String baseURL;

    ArrayList<Film> results = new ArrayList<>();

    public FilmService(HttpClient starWarsClient, String baseURL){
        this.starWarsClient = starWarsClient;
        this.baseURL = Helpers.normalizeBaseURL(baseURL);
    }

    public ArrayList<Film> getFilms(){
        if(!results.isEmpty()) return results;
        FilmPage result;
        String nextURL = "";
        try{
            while(true){
                result = starWarsClient.getOne(baseURL + nextURL, FilmPage.class);
                results.addAll(result.results());
                if(result.next() == null) break;
                nextURL = result.next().substring(result.next().indexOf("?"));
            }
            return results;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
