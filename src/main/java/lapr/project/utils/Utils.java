package lapr.project.utils;

import lapr.project.ui.MenuItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static int readIntegerFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                int value = Integer.parseInt(input);

                return value;
            } catch (NumberFormatException ex) {
                throw new NumberFormatException();
            }
        } while (true);
    }

    public static String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object showAndSelectOne(List list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    public static int showAndSelectIndex(List list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    public static void showList(List<MenuItem> list, String header) {
        System.out.println(header);

        int index = 0;
        for (MenuItem o : list) {
            index++;

            System.out.println(index + ". " + o.getDescription());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }

    public static Object selectsObject(List list) {
        String input;
        Integer value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value = Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    public static int selectsIndex(List list) {
        String input;
        Integer value;
        do {

            input = Utils.readLineFromConsole("Type your option: ");
            value = detectNumberFormatException(input);
        } while (value < -1 || value > list.size());

        return value - 1;
    }

    public static Integer detectNumberFormatException(String s) {
        Integer n;
        try {
            n = Integer.valueOf(s);
            return n;
        } catch (NumberFormatException ex) {
            System.out.println("This is not an option!");
            return -2;
        }
    }
}