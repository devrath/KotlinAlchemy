package com.istudio.app.modules.module_demos.kotlin_annotations.utils.stringRes

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.ui.graphics.vector.ImageVector
import com.istudio.app.R

sealed class HomeNavItem(
    val route: String,
    val iconSelected: ImageVector,
    val iconUnSelected: ImageVector,
    @StringRes val title: Int
) {
    // <--------- MyBooks Screen --------->
    object MyBooks : HomeNavItem(
        route = "myBooks",
        title = R.string.app_books,
        iconSelected = Icons.Filled.Add,
        iconUnSelected = Icons.Outlined.Add,
    )

    // <--------- BookReviews Screen --------->
    object BookReviews : HomeNavItem(
        route = "bookReviews",
        title = R.string.app_reviews,
        iconSelected = Icons.Filled.Create,
        iconUnSelected = Icons.Outlined.Create,
    )

    // <--------- ReadingList Screen --------->
    object ReadingList : HomeNavItem(
        route = "readingList",
        title = R.string.app_reading_list,
        iconSelected = Icons.Filled.MoreVert,
        iconUnSelected = Icons.Outlined.MoreVert,
    )
}