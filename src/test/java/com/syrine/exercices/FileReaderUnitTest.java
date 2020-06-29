package com.syrine.exercices;

import com.syrine.exercices.services.FileReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileReaderUnitTest {

    @Test
    public void should_Read_An_Existing_File_Correctly() {
        // act

        try {
            FileReader fileReader = new FileReader();
            String expectedOutput = "LMLMLMLMM";
            List<String> fileContent = fileReader.ReadFile("testFile.txt");
            // assert
            assertEquals(fileContent.get(0),expectedOutput);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_Throw_An_Exception_If_File_Not_Found(){
        try{
            FileReader fileReader = new FileReader();
            List<String> fileContent = fileReader.ReadFile("notExistingFile.txt");
            fail();
        }
        catch(IOException ex) {
            assertTrue(true);
        }
    }
}
