package com.istudio.code.modules.jvmStatic;

public class DemoJvmStaticAnnotation {
    public void initiate() {
        // Actor name cannot be accessed without using INSTANCE
        System.out.println(
                KotlinUtils.INSTANCE.getActorName()
        );
        // Observe that here the INSTANCE is not used because @JvmStatic is mentioned
        System.out.println(
                KotlinUtils.getActressName()
        );
    }
}
