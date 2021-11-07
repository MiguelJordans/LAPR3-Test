package lapr.project.ui;

import lapr.project.controller.PositionalMessageController;
import lapr.project.model.Ship;

import java.util.Scanner;

public class PositionalMessageUI implements Runnable {

   private PositionalMessageController positionalMessageController = new PositionalMessageController();


    public void run(){


        int mmsi;
        Scanner read = new Scanner(System.in);

        System.out.println("Which ship will you read the positional messages?");
        mmsi = read.nextInt();

        if(!positionalMessageController.getPositionalMessages(mmsi)){
            System.out.println(mmsi+" doesn't exist!");
        }

    }


}
