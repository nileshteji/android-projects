package com.arcore.dependencyinjection;

import javax.inject.Inject;

public class ClassTwo {
    //we should alwayys use the inject keyword with constructor
    ClassOne classOne;

    @Inject
    ClassTwo(ClassOne classOne) {
        this.classOne = classOne;
    }

    void print(){
        classOne.print();
    }

}
