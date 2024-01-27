package com.istudio.app.modules.module_demos.kotlin_annotations.utils.nullableAndNotNull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SuperHero {

    private String name;

    public @Nullable String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

}
