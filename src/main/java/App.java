import backend.HttpClient;
import backend.services.FilmService;
import backend.services.PeopleService;
import backend.services.PlanetService;
import ui.Gui;
import ui.UIController;

import java.io.IOException;

/*
Initializes everything
UI
    GUI (Window management wrapper) -> UIController (Navigation) -> Windows (What we see)
Backend
    Service (used in UIController)
 */
public class App {
    public static void run() {
        try {
            // HttpClients
            HttpClient starWarsClient = new HttpClient("https://swapi.dev/api/");

            // Services
            PeopleService peopleService = new PeopleService(starWarsClient, "people/");
            PlanetService planetService = new PlanetService(starWarsClient, "planets/"); //dependency injection (DI)
            FilmService filmService = new FilmService(starWarsClient, "films/");
            // GUI
            Gui gui = new Gui();
            gui.start();
            UIController ui = new UIController(gui, peopleService, planetService, filmService);
            ui.showMainMenu();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
