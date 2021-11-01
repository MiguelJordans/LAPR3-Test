package lapr.project.ui;


<<<<<<< HEAD

=======
import lapr.project.utils.MenuItem;
>>>>>>> 4e6f34017a297fcd12ad0f1da2c2ee196daa9129
import lapr.project.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TrafficManagerUI implements Runnable {

    public void run() {

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Pls don't bug", new ShowTextUI("OLA")));

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

