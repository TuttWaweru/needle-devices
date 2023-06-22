package needles.devices.com.androidApp.composeui.navigation

import needles.devices.com.androidApp.utils.NavigationRoutes

sealed class Screen(val route: String) {
    object AuthWelcome : Screen(NavigationRoutes.Auth.WELCOME)
    object Register : Screen(NavigationRoutes.Auth.REGISTER)
    object Login : Screen(NavigationRoutes.Auth.LOGIN)
    object ResetPassword : Screen(NavigationRoutes.Auth.RESET_PASSWORD)
    object Home : Screen(NavigationRoutes.Home.BASE)
}

class AppNavHost