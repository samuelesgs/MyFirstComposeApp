package com.saltwortdevs.myfirstcomposeapp.components

import android.graphics.drawable.Icon
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saltwortdevs.myfirstcomposeapp.components.model.DrawerItem
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(
    drawerState: DrawerState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    rememberCoroutineScope()
    val myItems = listOf(
        DrawerItem("Home", Icons.Default.Home, 1),
        DrawerItem("Favs", Icons.Default.Favorite, 2),
        DrawerItem("Tools", Icons.Default.Build, 3),
        DrawerItem("Call", Icons.Default.Call, 5),
        DrawerItem("Location", Icons.Default.LocationOn, 2),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(
                    topEndPercent = 12,
                    bottomEndPercent = 12,
                    bottomStartPercent = 0,
                    topStartPercent = 0
                ),
                drawerContentColor = Color.DarkGray,
                drawerContainerColor = Color.Gray
            ) {
                /*Text(
                    "Ejemplo 1",
                    modifier = Modifier.clickable { scope.launch { drawerState.close() } })
                Text("Ejemplo 2")
                Text("Ejemplo 3")
                Text("Ejemplo 4")*/
                Spacer(Modifier.height(44.dp))
                myItems.forEachIndexed { index, item ->
                    ItemMenuDrawer(item, index == selectedIndex) {
                        selectedIndex = index
                    }

                }
            }
        },
        scrimColor = Color.DarkGray
    ) {
        content()
    }
}

@Composable
fun ItemMenuDrawer(drawerItem: DrawerItem, isSelected: Boolean, onItemMenuSelected: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(drawerItem.title) },
        selected = isSelected,
        onClick = {
            onItemMenuSelected()
        },
        icon = { Icon(imageVector = drawerItem.icon, contentDescription = "") },
        badge = {
            if (drawerItem.notification > 0) {
                Badge { Text(drawerItem.notification.toString()) }
            }
        },
        shape = RoundedCornerShape(0),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.DarkGray,
            unselectedContainerColor = Color.Gray,
            selectedIconColor = Color.White,
            unselectedIconColor = Color.DarkGray,
            selectedTextColor = Color.White,
            unselectedTextColor = Color.DarkGray,
            selectedBadgeColor = Color.White,
            unselectedBadgeColor = Color.DarkGray,
        )
    )
}