package com.syrine.exercices;

import com.syrine.exercices.models.Plateau;
import com.syrine.exercices.models.RoverPosition;
import com.syrine.exercices.services.PlateauInitializer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class PlateauInitializerUnitTest  {

    @Test
    public void initialize_Plateau_Should_Return_A_Correct_Plateau(){
        // arrange
        ArrayList<String> input = new ArrayList<String>() ;
        input.add("1 2");
        PlateauInitializer plateauInitializer = new PlateauInitializer();
        Plateau expectedPlateau = new Plateau(1,2);
        //act
        Plateau createdPlateau = plateauInitializer.initializePlateau(input);
        //assert
        assertEquals(createdPlateau,expectedPlateau);
    }


    @Test
    public void initialize_Plateau_should_throw_an_exception(){
        // arrange
        ArrayList<String> input = new ArrayList<String>() ;
        input.add("bc");
        PlateauInitializer plateauInitializer = new PlateauInitializer();
        //act
        try {
            Plateau newPlateau = plateauInitializer.initializePlateau(input);
            fail("A new plateau was created even with corrupted input");
            }
        catch (Exception ex) {
            Assert.assertTrue(true);
            ex.printStackTrace();
            }
        }


    @Test
    public void should_Initialize_Rovers_Correctly(){
        try {
        //arrange
        ArrayList<String> input = new ArrayList<String>() ;
        input.add("5 5");
        input.add("1 2 N");
        RoverPosition expectedRoverPosition = new RoverPosition(1,2,'N');
        // act
        List<RoverPosition> roverPositions = PlateauInitializer.initializeRovers(input);
        //assert
        assertEquals(roverPositions.get(0),expectedRoverPosition);}
        catch (Exception e) {
            fail();
        }
    }

    @Test
    public void Should_Throw_An_Exception_If_Rover_Position_Is_Invalid() {
        try {
            // arrange
            ArrayList<String> input = new ArrayList<String>();
            input.add("5 5");
            input.add("P 2 P");
            //act
            PlateauInitializer.initializeRovers(input);
            //assert
            fail();
        }
        catch(Exception e) {
            assertTrue(true);
            e.printStackTrace();
        }
    }

    @Test
    public void Should_Initialize_Instruction_Correctly() {
        try {
            ArrayList<String> input = new ArrayList<String>();
            input.add("5 5");
            input.add("P 2 P");
            input.add("LMLMLMLMM");
            String expectedInstruction = "LMLMLMLMM";
            // act
            List<String> instructions = PlateauInitializer.initializeInstructions(input);
            // assert
            assertEquals(expectedInstruction,instructions.get(0));
        }
        catch (Exception e) {
            fail();
        }
    }

    @Test
    public void Should_Throw_An_Exception_If_Invalid_Instruction() {
        try {
            //arrange
            ArrayList<String> input = new ArrayList<String>();
            input.add("5 5");
            input.add("P 2 P");
            input.add("P35");
            //act
            List<String> instructions = PlateauInitializer.initializeInstructions(input);
            //assert
            fail();
        }
        catch(Exception e) {
            assertTrue(true);
        }
    }

}
