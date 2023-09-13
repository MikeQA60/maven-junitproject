package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;


public class Hooks {

    @Before (order = 3)
    public void setUp() {
        System.out.println("Setting up in Cucumber before Hooks");
    }

    @Before(order = 1)
    public void setUpDatabase() {
        // Code to set up database
        System.out.println("Code to set up database before hooks");
    }

    @Before(order = 2, value ="@ui")
    public void setUpWebdriver() {
        // Code to set up webdriver
        System.out.println("Code to set up webdrive before hooks");
    }

    @After
    public void cleanUp() {
        System.out.println("Cleanup in cucumber");

    }

    @BeforeAll
    public static void globalSetup(){
        System.out.println("It should only run once before the entire suite");
    }
}
