package lapr.project.ui;

import lapr.project.model.Ship;

import java.util.Scanner;

public class PositionalMessageUI implements Runnable {




    public void run(){

        long mmsi;
        Scanner read = new Scanner(System.in);

        System.out.println("Which ship will you read the positional messages?");
        mmsi = read.nextLong();


    }


}
