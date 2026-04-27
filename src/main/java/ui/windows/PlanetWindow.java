package ui.windows;

import backend.services.FilmService;
import backend.services.PlanetService;
import com.googlecode.lanterna.gui2.*;
import models.Film;
import models.Planet;
import ui.UIController;

import java.util.ArrayList;
import java.util.List;

public class PlanetWindow extends BasicWindow {
    private final UIController ui;
    private final Planet planet;
    private final FilmService service; //check if you need this

    public PlanetWindow(UIController ui, Planet planet, FilmService service){
        super(planet.name());
        this.ui = ui;
        this.planet = planet;
        this.service = service;
        setHints(List.of(Hint.CENTERED));
        setComponent(build());
    }

    private Component build(){
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL)
        );
        ActionListBox alb = new ActionListBox();
        panel.addComponent(alb);

        int count = 0;
        for(String x : planet.residents()){
            count++;
        }

        alb.addItem("Planet Name: " + planet.name(), () -> {});
        alb.addItem("Num. Residents: " + count, () -> {}); //you need to show only thr number
        alb.addItem("Films: ", () -> {});
        ArrayList<Film> film = service.getFilms();
        for(Film filmObj : film){
            alb.addItem("-- " + filmObj.title(), () -> {});
        }

        panel.addComponent(new Button("Back", () -> ui.closeWindow(this)));
        return panel;
    }
}
