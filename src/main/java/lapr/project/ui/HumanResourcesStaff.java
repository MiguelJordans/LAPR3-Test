package lapr.project.ui;

import lapr.project.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HumanResourcesStaff implements Runnable {

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a new Employee", new PositionalMessageUI()));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nHuman Resources Staff Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }

}
