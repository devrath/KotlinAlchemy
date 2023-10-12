package com.istudio.code.modules.jvmField;

import com.istudio.code.utils.PrintUtils;

public class DemoJavaJvmAnnotation {
    public void initiate() {
        // Compiler will understand getter and setter will not be needed and we can access the field directly
        Person person = new Person("Suresh",23);
        PrintUtils.INSTANCE.printLog(person.name); // Observe we have not used getter method still able to access the field
        PrintUtils.INSTANCE.printLog(String.valueOf(person.getAge())); // Since the jvm annotation is not present for this field, We need a getter method to access the field
    }
}
