package needle.devices.com.androidApp.composeui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import needle.devices.com.androidApp.composeui.screens.auth.AuthWelcomeRoute
import needle.devices.com.androidApp.composeui.screens.auth.LoginScreenRoute
import needle.devices.com.androidApp.composeui.screens.auth.RegisterScreenRoute
import needle.devices.com.androidApp.utils.NavigationRoutes

sealed class Screen(val route: String) {
    object AuthWelcome : Screen(NavigationRoutes.Auth.WELCOME)
    object Register : Screen(NavigationRoutes.Auth.REGISTER)
    object Login : Screen(NavigationRoutes.Auth.LOGIN)
    object ResetPassword : Screen(NavigationRoutes.Auth.RESET_PASSWORD)
    object Home : Screen(NavigationRoutes.Home.BASE)
}

class AppNavHost

@Composable
fun NavGraphBuilder.AddNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AuthWelcome.route,
        builder = {
            composable(Screen.AuthWelcome.route) {
                // AuthWelcome screen
                AuthWelcomeRoute()
            }
            composable(Screen.Register.route) {
                RegisterScreenRoute()
            }
            composable(Screen.Login.route) {
                LoginScreenRoute()
            }
            composable(Screen.ResetPassword.route) {
                // ResetPassword screen
            }
        }
    )
}