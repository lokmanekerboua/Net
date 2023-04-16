package com.example.net.ui.homeScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.net.ui.graphs.CalcScreens
import com.example.net.ui.graphs.HomeNavGraph
import com.example.net.utils.Constants.Companion.fontfamily

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true , showBackground = true)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        CalcScreens.Devices,
        CalcScreens.Pane,
        CalcScreens.Calculate,
        CalcScreens.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentdestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentdestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            elevation = 0.dp
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentdest = currentdestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: CalcScreens,
    currentdest: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(label = { Text(text = screen.title, fontFamily = fontfamily) }, icon = {
        Icon(
            imageVector = screen.icon,
            contentDescription = null
        )
    },
        selected = currentdest?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}