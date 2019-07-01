package com.example.uipl.serviceexample;

class SingletonClass
{
    // static variable single_instance of type Singleton
    private static SingletonClass single_instance = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private SingletonClass()
    {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static SingletonClass getInstance()
    {
        if (single_instance == null)
            single_instance = new SingletonClass();

        return single_instance;
    }


    public  void simpleTest(){

    }
}

// Driver Class
class Main
{
    public static void main(String args[])
    {
        // instantiating Singleton class with variable x
        SingletonClass x = SingletonClass.getInstance();

        // instantiating Singleton class with variable y
        SingletonClass y = SingletonClass.getInstance();

        // instantiating Singleton class with variable z
        SingletonClass z = SingletonClass.getInstance();

        // changing variable of instance x
        x.s = (x.s).toUpperCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");

        // changing variable of instance z
        z.s = (z.s).toLowerCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}
