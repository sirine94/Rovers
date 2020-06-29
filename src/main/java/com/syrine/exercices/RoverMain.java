package com.syrine.exercices;

import com.syrine.exercices.models.Plateau;
import com.syrine.exercices.models.RoverPosition;
import com.syrine.exercices.services.FileReader;
import com.syrine.exercices.services.MovementApplier;
import com.syrine.exercices.services.PlateauInitializer;

import java.util.List;

public class RoverMain {


    public static void main(String[] args) {
        try {
            if(args.length == 0) throw new Exception("Please enter as argument the input file.");
            String fileName = args[0];
            List text = FileReader.ReadFile(fileName);
            Plateau plateau = PlateauInitializer.initializePlateau(text);
            List<RoverPosition> roverPositions = PlateauInitializer.initializeRovers(text);
            List<String> instructions = PlateauInitializer.initializeInstructions(text);
            MovementApplier.moveRovers(instructions, roverPositions, plateau);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}



