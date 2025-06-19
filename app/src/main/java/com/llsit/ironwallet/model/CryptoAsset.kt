package com.llsit.ironwallet.model

import androidx.compose.ui.graphics.vector.ImageVector

data class CryptoAsset(
    val name: String,
    val symbol: String,
    val balance: String,
    val usdValue: String,
    val change: String,
    val isPositive: Boolean,
    val icon: ImageVector
)