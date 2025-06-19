package com.llsit.ironwallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.llsit.ironwallet.presentation.screen.MainWalletScreen
import com.llsit.ironwallet.presentation.screen.OnboardingScreen
import com.llsit.ironwallet.presentation.screen.RecoveryPhraseScreen
import com.llsit.ironwallet.ui.theme.IronWalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IronWalletTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Web3WalletApp(innerPadding)
                }
            }
        }
    }
}

@Composable
fun Web3WalletApp(innerPadding: PaddingValues) {
    var currentScreen by remember { mutableIntStateOf(0) }

    when (currentScreen) {
        0 -> OnboardingScreen { currentScreen = 1 }
        1 -> MainWalletScreen(
            onRecoveryPhrase = { currentScreen = 2 },
            onBack = { currentScreen = 0 }
        )

        2 -> RecoveryPhraseScreen(
            onBack = { currentScreen = 1 },
            onSaved = { currentScreen = 1 }
        )
    }
}