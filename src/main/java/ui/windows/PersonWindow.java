package ui.windows;

import backend.services.PlanetService;
import com.googlecode.lanterna.gui2.*;
import models.Person;
import models.Planet;
import ui.UIController;
import java.util.ArrayList;
import java.util.List;
import com.googlecode.lanterna.gui2.*;

public class PersonWindow extends BasicWindow {
    private final UIController ui;
    private final Person person;
    private final PlanetService service;

    public PersonWindow(UIController ui, Person person, PlanetService service) {
        super(person.name());
        this.ui = ui;
        this.person = person;
        this.service = service;

        setHints(List.of(Hint.CENTERED));
        setComponent(build());
    }

    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL)
        );
        ActionListBox alb = new ActionListBox();
        panel.addComponent(alb);

        Planet planet = service.getPlanet(person.homeworld());

        /*ArrayList<Planet> planets = new ArrayList<>();
        for(Planet p : planets){
            alb.addItem("Hi we're testing", () -> {
              // ui.showPlanetWindow(Planet planet);
            });
        }*/

        alb.addItem("Name: " + person.name(), () -> {});
        alb.addItem("Home World: " + planet.name(), () -> {
            ui.showPlanetWindow(planet);
        });
        alb.addItem("Birth Year: " + person.birthYear(), () -> {});

        panel.addComponent(new Button("Back", () -> ui.closeWindow(this)));

        return panel;
    }
    }

//use person.homeworld() to get the url
//use the url to make an api request
//use the result in our api request



