package lapr.project.ui;

import lapr.project.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TrafficManagerUI implements Runnable {

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Positional Message of a Ship", new PositionalMessageUI()));
        options.add(new MenuItem("Ship list", new ListShipsUI()));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nTraffic Manager Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}