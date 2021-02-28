package com.moriswala.firstcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.moriswala.firstcompose.MainDestinations.PUPPY_DETAIL_ID_KEY
import com.moriswala.firstcompose.model.puppies
import com.moriswala.firstcompose.ui.puppies.PuppiesList
import com.moriswala.firstcompose.ui.puppy.PuppyDetails

/**
 * Destinations used in the ([FirstCompose]).
 */
object MainDestinations {
    const val PUPPIES_ROUTE = "puppies"
    const val PUPPY_DETAIL_ROUTE = "puppy"
    const val PUPPY_DETAIL_ID_KEY = "puppyId"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.PUPPIES_ROUTE) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.PUPPIES_ROUTE) {
            val modifier = Modifier.padding(8.dp)
            PuppiesList(puppies, actions.selectedPuppy, modifier)
        }
        composable(
            "${MainDestinations.PUPPY_DETAIL_ROUTE}/{$PUPPY_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(PUPPY_DETAIL_ID_KEY) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            PuppyDetails(
                puppyId = arguments.getLong(PUPPY_DETAIL_ID_KEY),
                selectedPuppy = actions.selectedPuppy,
                upPress = actions.upPress
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectedPuppy: (Long) -> Unit = { puppyId: Long ->
        navController.navigate("${MainDestinations.PUPPY_DETAIL_ROUTE}/$puppyId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
