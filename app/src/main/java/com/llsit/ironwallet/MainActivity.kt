package com.llsit.ironwallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llsit.ironwallet.presentation.screen.BiometricSetupScreen
import com.llsit.ironwallet.presentation.screen.CreateNewWalletScreen
import com.llsit.ironwallet.presentation.screen.ImportWalletScreen
import com.llsit.ironwallet.presentation.screen.MainWalletScreen
import com.llsit.ironwallet.presentation.screen.OnboardingScreen
import com.llsit.ironwallet.presentation.screen.RecoveryPhraseScreen
import com.llsit.ironwallet.presentation.screen.WalletSetupScreen
import com.llsit.ironwallet.ui.theme.IronWalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IronWalletTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Web3WalletApp()
                    }
                }
            }
        }
    }
}

enum class MainScreen() {
    Onboarding,
    SetupWallet,
    ImportWallet,
    CreateWallet,
    BiometricAuth,
    MainWallet,
    RecoveryPhrase,
}

@Composable
fun Web3WalletApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = MainScreen.Onboarding.name) {
        composable(route = MainScreen.Onboarding.name) {
            OnboardingScreen {
                navController.navigate(MainScreen.SetupWallet.name)
            }
        }
        composable(route = MainScreen.SetupWallet.name) {
            WalletSetupScreen(
                onCreateWallet = { navController.navigate(MainScreen.CreateWallet.name) },
                onImportWallet = { navController.navigate(MainScreen.ImportWallet.name) },
                onBack = { navController.navigate(MainScreen.Onboarding.name) }
            )
        }
        composable(route = MainScreen.ImportWallet.name) {
            ImportWalletScreen(
                onBack = { navController.navigate(MainScreen.SetupWallet.name) },
                onImported = { navController.navigate(MainScreen.MainWallet.name) }
            )
        }
        composable(route = MainScreen.CreateWallet.name) {
            CreateNewWalletScreen(
                onBack = { navController.navigate(MainScreen.SetupWallet.name) },
                onCreateWallet = { navController.navigate(MainScreen.MainWallet.name) }
            )
        }
        composable(MainScreen.RecoveryPhrase.name) {
            RecoveryPhraseScreen(
                onBack = { navController.navigate(MainScreen.CreateWallet.name) },
                onSaved = { navController.navigate(MainScreen.BiometricAuth.name) }
            )
        }
        composable(MainScreen.BiometricAuth.name) {
            BiometricSetupScreen(
                onBack = { navController.navigate(MainScreen.CreateWallet.name) },
                onComplete = { navController.navigate(MainScreen.MainWallet.name) }
            )
        }
        composable(MainScreen.MainWallet.name) {
            MainWalletScreen(
                onRecoveryPhrase = { navController.navigate(MainScreen.RecoveryPhrase.name) },
                onBack = { navController.navigate(MainScreen.Onboarding.name) }
            )
        }
    }
}