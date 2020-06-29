package com.syrine.exercices;

import com.syrine.exercices.models.Plateau;
import com.syrine.exercices.models.RoverPosition;
import com.syrine.exercices.services.MovementApplier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MovementApplierUnitTest {

    private RoverPosition SimulateRogersMovement(RoverPosition rover, String instruction) {
            List<RoverPosition> rovers = new ArrayList<>();
            try{
                Plateau plateau = new Plateau(5, 5);
            rovers.add(rover);
            List<String> instructions = new ArrayList<>();
            instructions.add(instruction);
            MovementApplier.moveRovers(instructions, rovers, plateau);
        } catch(Exception e){
            fail();
        }
        return rovers.get(0);
    }

    @Test
    public void should_Turn_Rover_Left_Correctly() {
        //arrange
        RoverPosition currentRoverPosition = new RoverPosition(1,1,'N');
        String instruction = "L";
        RoverPosition expectedRoverPosition = new RoverPosition(1,1,'W');
        // act
        currentRoverPosition = SimulateRogersMovement(currentRoverPosition,instruction);
        // assert
        assertEquals(currentRoverPosition,expectedRoverPosition);
    }

    @Test
    public void should_Turn_Rover_Right_Correctly() {
        //arrange
        RoverPosition currentRoverPosition = new RoverPosition(1,1,'N');
        String instruction = "R";
        RoverPosition expectedRoverPosition = new RoverPosition(1,1,'E');
        // act
        currentRoverPosition = SimulateRogersMovement(currentRoverPosition,instruction);
        // assert
        assertEquals(currentRoverPosition,expectedRoverPosition);
    }

    @Test
    public void should_Move_Rover_Forward_When_Headed_To_North_Correctly() {
        //arrange
        RoverPosition currentRoverPosition = new RoverPosition(1,1,'N');
        String instruction = "M";
        RoverPosition expectedRoverPosition = new RoverPosition(1,2,'N');
        // act
        currentRoverPosition = SimulateRogersMovement(currentRoverPosition,instruction);
        // assert
        assertEquals(currentRoverPosition,expectedRoverPosition);
    }

    @Test
    public void should_Move_Rover_Forward_When_Headed_To_South_Correctly() {
        //arrange
        RoverPosition currentRoverPosition = new RoverPosition(1,1,'S');
        String instruction = "M";
        RoverPosition expectedRoverPosition = new RoverPosition(1,0,'S');
        // act
        currentRoverPosition = SimulateRogersMovement(currentRoverPosition,instruction);
        // assert
        assertEquals(currentRoverPosition,expectedRoverPosition);
    }

    @Test
    public void should_Move_Rover_Forward_When_Headed_To_East_Correctly() {
        //arrange
        RoverPosition currentRoverPosition = new RoverPosition(1,1,'E');
        String instruction = "M";
        RoverPosition expectedRoverPosition = new RoverPosition(2,1,'E');
        // act
        currentRoverPosition = SimulateRogersMovement(currentRoverPosition,instruction);
        // assert
        assertEquals(currentRoverPosition,expectedRoverPosition);
    }

    @Test
    public void should_Move_Rover_Forward_When_Headed_To_West_Correctly() {
        //arrange
        RoverPosition currentRoverPosition = new RoverPosition(1,1,'W');
        String instruction = "M";
        RoverPosition expectedRoverPosition = new RoverPosition(0,1,'W');
        // act
        currentRoverPosition = SimulateRogersMovement(currentRoverPosition,instruction);
        // assert
        assertEquals(currentRoverPosition,expectedRoverPosition);
    }
}
