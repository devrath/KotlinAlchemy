package com.istudio.app.modules.module_demos.basic_fundamentals.utils.multipleInheritance.in_java;


public class InJava implements Sony,Samsung{
    @Override
    public void content() {
        System.out.println("Television content");
    }

    @Override
    public void methodSonyName() {
        System.out.println("Sony name");
    }

    @Override
    public void methodSamsungName() {
        System.out.println("Samsung name");
    }
}


interface Telivision{
    void content();
}

interface Sony extends Telivision{
    void methodSonyName();
}

interface Samsung extends Telivision{
    void methodSamsungName();
}