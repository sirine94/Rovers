package com.syrine.exercices.services;

import com.syrine.exercices.models.Plateau;
import com.syrine.exercices.models.RoverPosition;

import java.util.ArrayList;
import java.util.List;

public class PlateauInitializer {

    public static Plateau initializePlateau(List<String> list){
        Plateau plateau;
        int x,y;
        try {
            x = Integer.parseInt(list.get(0).split(" ")[0]);
            y = Integer.parseInt(list.get(0).split(" ")[1]);
            plateau = new Plateau(x, y);
            return plateau;
        } catch(Exception e){
            System.out.println("The input format of the plateau coordinates is not correct. please set if before executing the program.");
            throw e;

        }
    }

    public static List<RoverPosition> initializeRovers(List<String> list) throws Exception {
        List<RoverPosition> rovers = new ArrayList<>();
        int x,y;
        try{
            for (int i=1; i < list.size(); i+=2) {
                x = Integer.parseInt(list.get(i).split(" ")[0]);
                y = Integer.parseInt(list.get(i).split(" ")[1]);
                char orientation = list.get(i).split(" ")[2].charAt(0);
                if (orientation != 'N' && orientation != 'O' && orientation != 'S' && orientation != 'E')
                    throw new Exception("The orientation Letter is not N or O or S or E, please set it correctly before executing the program");
                rovers.add(new RoverPosition(x, y, orientation));
            }
        } catch(Exception e){
            System.out.println("The input format is not correct. please set if before executing the program." );
            throw e;
        }
        return rovers;
    }

    public static List<String> initializeInstructions(List<String> list) throws Exception {
        List<String> instructions = new ArrayList<>();
        try {
            for (int i = 2; i < list.size(); i += 2) {

                if (!(list.get(i).matches("[LMR]+")))
                    throw new Exception("The movement Letter is not L or R or S or M, please set it correctly before executing the program");
                instructions.add(list.get(i));
            }
        } catch(Exception e){
            System.out.println("The input format is not correct. please set if before executing the program.");
            throw  e;
        }
        return instructions;
    }

}
