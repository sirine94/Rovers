package com.syrine.exercices.services;

import com.syrine.exercices.models.Plateau;
import com.syrine.exercices.models.RoverPosition;

import java.util.List;

public class MovementApplier {

    public static void moveRovers (List<String> instructions, List<RoverPosition> rovers, Plateau plateau) throws Exception{
        try{
        for (int j=0; j < instructions.size(); j++){
            String instruction = instructions.get(j);
            RoverPosition roverPosition = rovers.get(j);
            roverPosition = ApplyInstruction(instruction,roverPosition,plateau);
            System.out.println(roverPosition.toString());
        } } catch(Exception e){
            throw e;
    }
    }

    private static RoverPosition ApplyInstruction(String instruction,RoverPosition roverPosition,Plateau plateau) throws Exception {
        for(int i=0; i < instruction.length(); i++){
            switch (instruction.charAt(i)){
                case 'L':
                    turnLeft(roverPosition);
                    break;
                case 'R':
                    turnRight(roverPosition);
                    break;
                case 'M':
                    moveForward(roverPosition,plateau);
                    break;
            }
        }
        return roverPosition;
    }

    private static void turnLeft(RoverPosition rover){
        char orientation = rover.getOrientation();
        switch (orientation){
            case 'N':
                rover.setOrientation('W');
                break;
            case 'W':
                rover.setOrientation('S');
                break;
            case 'S':
                rover.setOrientation('E');
                break;
            case 'E':
                rover.setOrientation('N');
                break;
        }
    }
    private static void turnRight(RoverPosition rover){
        char orientation = rover.getOrientation();
        switch (orientation){
            case 'N':
                rover.setOrientation('E');
                break;
            case 'W':
                rover.setOrientation('N');
                break;
            case 'S':
                rover.setOrientation('W');
                break;
            case 'E':
                rover.setOrientation('S');
                break;
        }
    }
    private static void moveForward(RoverPosition rover,Plateau plateau) throws Exception{
        char orientation = rover.getOrientation();
        if (orientation == 'N' && rover.getY() < plateau.getY())
                rover.setY(rover.getY()+1);
        else if (orientation == 'W' && rover.getX() > 0 )
                rover.setX(rover.getX()-1);
        else if (orientation == 'S' && rover.getY() > 0 )
                rover.setY(rover.getY()-1);
        else if (orientation == 'E' && rover.getX() < plateau.getX() )
                rover.setX(rover.getX()+1);
        else throw new Exception("Movement is not allowed outside the plateau.");
        }
    }

