package com.llsit.ironwallet.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsit.ironwallet.R
import com.llsit.ironwallet.model.CryptoAsset
import com.llsit.ironwallet.model.WalletAction
import com.llsit.ironwallet.presentation.component.ActionButton
import com.llsit.ironwallet.presentation.component.AssetItem
import com.llsit.ironwallet.presentation.component.BottomNavigation
import com.llsit.ironwallet.presentation.component.TabItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWalletScreen(
    onRecoveryPhrase: () -> Unit,
    onBack: () -> Unit
) {
    val assets = listOf(
        CryptoAsset(
            "Solana",
            "SOL",
            "0.13",
            "$129.13",
            "-0.86 SOL",
            false,
            Icons.Default.Star
        ),
        CryptoAsset(
            "Official Trump",
            "TRUMP",
            "10.39",
            "$16.07",
            "-1.54 TRUMP",
            false,
            Icons.Default.Star
        ),
        CryptoAsset(
            "Tether",
            "USDT",
            "1.00",
            "$31.87",
            "-31.87 USDT",
            false,
            Icons.Default.Star
        ),
        CryptoAsset(
            "dogwifhat",
            "WIF",
            "0.00",
            "$12.52",
            "-14.09 WIF",
            false,
            Icons.Default.DateRange
        )
    )

    val actions = listOf(
        WalletAction("Receive", R.drawable.ic_inbox),
        WalletAction("Buy", R.drawable.ic_buy),
        WalletAction("Swap", R.drawable.ic_exchange),
        WalletAction("Stake", R.drawable.ic_stake),
        WalletAction("Send", R.drawable.ic_send)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A1A1A),
                        Color(0xFF000000)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(Color(0xFF4CAF50), Color(0xFF2196F3))
                                ),
                                CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Main Wallet",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Tezos",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                    }
                }

                IconButton(onClick = onRecoveryPhrase) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }

            // Balance
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BALANCE",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "$18900.59",
                    color = Color.White,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Action Buttons
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                items(actions) { action ->
                    ActionButton(action = action)
                }
            }

            // Tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                TabItem("Tab Item", true)
                TabItem("Collectibles", false)
                TabItem("Staking", false)
            }

            // Import Token Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { /* Handle import */ }) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFF9CFF2E),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Import Token",
                        color = Color(0xFF9CFF2E),
                        fontSize = 14.sp
                    )
                }
            }

            // Assets List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(assets) { asset ->
                    AssetItem(asset = asset)
                }
            }
        }

        // Bottom Navigation
        BottomNavigation(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainWalletScreen() {
    MainWalletScreen(onRecoveryPhrase = {}, onBack = {})
}