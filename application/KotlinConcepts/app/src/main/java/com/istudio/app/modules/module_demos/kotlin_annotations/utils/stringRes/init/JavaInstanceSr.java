package com.istudio.app.modules.module_demos.kotlin_annotations.utils.stringRes.init;

import com.istudio.app.modules.module_demos.kotlin_annotations.utils.stringRes.HomeNavItem;

public class JavaInstanceSr {

    public void initilize() {
        System.out.println(HomeNavItem.BookReviews.INSTANCE.getTitle());
    }

}
