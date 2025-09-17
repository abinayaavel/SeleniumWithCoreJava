package test;

import org.testng.annotations.Test;

public class child1Class extends parentClass {

    @Test
    public void testRun() {

        int a = 3;
        child2Class c2 = new child2Class(a); // Parameterised constructor
        doThis(); // parent Class
        System.out.println(c2.decrement());
        System.out.println(c2.increment());

        System.out.println(c2.multiplyByThree());
        System.out.println(c2.multiplyByTwo());

    }

}
