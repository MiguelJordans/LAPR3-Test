package lapr.project.shared;

import lapr.project.model.Position;
import lapr.project.model.Ship;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DistanceCalculation {

    public static double distanceTo(Position pos, Position pos2) {


        double R = 6371;
        double lat = Math.toRadians((double) pos.getLatitude());
        double longi = Math.toRadians((double) pos.getLongitude());
        double lat2 = Math.toRadians((double) pos2.getLatitude());
        double longi2 = Math.toRadians((double) pos2.getLongitude());

        double intervaloLat = lat2 - lat;
        double intervaloLonge = longi2 - longi;

        double a = Math.sin(intervaloLat / 2) * Math.sin(intervaloLat / 2) + Math.cos(lat) * Math.cos(lat2) * Math.sin(intervaloLonge / 2) * Math.sin(intervaloLonge / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;

        return d;
    }



    public static double  traveledDistanceBaseDateTime(Ship ship, Date initiald, Date finald) {

        double d = 0;
        List<Position> positionList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initiald);
        Position sv1 ;
        Position sv2;



        while(initiald.before(finald)){




            if(calendar.getTime().getMinutes() == 60){
                calendar.add(Calendar.HOUR_OF_DAY,1);
                calendar.getTime().setMinutes(0);
                calendar.getTime().setSeconds(0);
            }
            if(calendar.getTime().getSeconds() == 60){
                calendar.add(Calendar.MINUTE,1);
                calendar.getTime().setSeconds(0);
            }


            for(Position pos : ship.getDate()){

                if(pos.getDate().equals(initiald)){

                    positionList.add(pos);
                }

            }

            calendar.add(Calendar.SECOND,1);
            initiald = calendar.getTime();
        }
        //out of the loop





        int count = 0;
        Position posA [] = new Position[2];

        for(Position pos : positionList){


            posA[count] = pos;
            count++;

            if(count == 2 &&  posA[0] != null && posA[1] != null){

                d = d + distanceTo(posA[0],posA[1]);

                count = 0;
                posA[count] = pos;
                count++;
            }





        }
        return d;
    }

}
