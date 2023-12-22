package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.init;

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmField.KotlinPerson;

public class JavaInstanceJf {

    public void initilize() {
        KotlinPerson person = new KotlinPerson("Suresh",21);
        // We are able to access the variable without getter method even if its a kotlin class
        System.out.println(person);
        System.out.println(person.getAge()+"");
    }

}
