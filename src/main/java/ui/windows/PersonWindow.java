package ui.windows;

import com.googlecode.lanterna.gui2.*;
import models.Person;
import ui.UIController;
import java.util.List;
import com.googlecode.lanterna.gui2.*;


public class PersonWindow extends BasicWindow {
    private final UIController ui;
    private final Person person;

    public PersonWindow(UIController ui, Person person) {
        super(person.name());
        this.ui = ui;
        this.person = person;
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

        alb.addItem("Name: " + person.name(), () -> {});
        alb.addItem("Home World: " + person.homeworld(), () -> {});
        alb.addItem("Birth Year: " + person.birthYear(), () -> {});

        panel.addComponent(new Button("Back", () -> ui.closeWindow(this)));

        return panel;
    }
    }



