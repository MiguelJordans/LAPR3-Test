package lapr.project.ui;

import lapr.project.controller.TopNShipsController;
import lapr.project.model.Ship;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TopNShipsUI implements Runnable {

    private TopNShipsController topNShipsController = new TopNShipsController();

    @Override
    public void run() {

        int n;
        Scanner read = new Scanner(System.in);
        String date;
        String vesselType;

        System.out.println("Top N?");
        n = read.nextInt();

        System.out.println("Vessel Type?");
        vesselType = read.next();

        System.out.println("Inital date? yyyy-MM-dd HH:mm");
        date = read.next();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        LocalDateTime datei = LocalDateTime.parse(date, dateFormat);


        System.out.println("Final date? yyyy-MM-dd HH:mm");
        date = read.next();

        LocalDateTime datef = LocalDateTime.parse(date,dateFormat);

        List<Ship> lShip = topNShipsController.getTopNShips(n,vesselType,datei,datef);

        if(lShip == null) System.out.println("Not sucessful");
        else{
            for(Ship  s : lShip)
                System.out.println(s);
        }
    }
}
