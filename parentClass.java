package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class parentClass {

    public void doThis() {
        System.out.println("I am here");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Run me first");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Run me last");

    }
}
