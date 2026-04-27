package models;

import java.util.ArrayList;

public record FilmPage(
        int count,
        String next,
        String previous,
        ArrayList<Film> results
){}
