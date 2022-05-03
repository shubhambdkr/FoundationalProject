package com.project0.StudyBuddy;

import static org.junit.Assert.*;

import org.junit.Test;

public class performanceTest {

	@Test
	public void showPerformance ()throws Exception {				
		
	    int percentage = 70;
	
        String performance = "";

        if(percentage > 50)
        {
            performance = "Good";
        }
        else if(percentage <= 50)
        {
            performance = "Poor";
        }

      
      
       assertEquals("Good",performance);
       
		}

}
