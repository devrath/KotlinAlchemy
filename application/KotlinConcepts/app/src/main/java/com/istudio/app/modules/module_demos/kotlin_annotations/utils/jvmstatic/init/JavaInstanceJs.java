package com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic.init;

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.jvmstatic.Cinema;

public class JavaInstanceJs {

    public void initilize() {
        System.out.println(Cinema.getActressName());
        System.out.println(Cinema.INSTANCE.getActorName());
        //System.out.println(Cinema.getActorName());// Not possible
    }

}
