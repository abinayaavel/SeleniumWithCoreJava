package test;

public class child2Class extends child3Class {

    int a;

    public child2Class(int a) {
        super(a); // parent class constructor is invoked
        this.a = a;
    }

    public int increment() {
        a = a + 1;
        return a;
    }

    public int decrement() {
        a = a - 1;
        return a;
    }

}
