package com.llsit.ironwallet.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsit.ironwallet.R

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF1A1A1A))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomNavItems("Balance", R.drawable.ic_wallet, true)
        BottomNavItems("Swap", R.drawable.ic_exchange, false)
        BottomNavItems("Activity", R.drawable.ic_restore, false)
        BottomNavItems("Settings", R.drawable.ic_settings, false)
    }
}

@Composable
fun BottomNavItems(title: String, icon: Int, isSelected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = title,
            tint = if (isSelected) Color.White else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            color = if (isSelected) Color.White else Color.Gray,
            fontSize = 12.sp
        )
    }
}