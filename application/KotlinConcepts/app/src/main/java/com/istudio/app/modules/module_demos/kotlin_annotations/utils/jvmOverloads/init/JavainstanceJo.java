package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.init;

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.Student1;
import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmOverloads.Student2;

public class JavainstanceJo {

    public void initilize() {
        Student1 stud1 = new Student1("Student1",20);
        Student2 stud2 = new Student2("Student1");// Observe we did not pass age, Default value is taken from kotlin class
    }

}
