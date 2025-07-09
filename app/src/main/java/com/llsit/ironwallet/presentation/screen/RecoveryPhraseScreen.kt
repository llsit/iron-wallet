package com.llsit.ironwallet.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsit.ironwallet.common.BaseContentAppScreen
import com.llsit.ironwallet.presentation.component.RecoveryWordItem

@Composable
fun RecoveryPhraseScreen(
    onBack: () -> Unit,
    onSaved: () -> Unit
) {
    val recoveryWords = listOf(
        "secure", "wallet", "honey",
        "board", "text", "table",
        "water", "coffe", "",
        "phone", "diff", "laptop",
        "cup", "", ""
    )

    BaseContentAppScreen {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        // Title
        Text(
            text = "Your 12-Word\nRecovery Phrase",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = "Keep this offline and never share with\nanyone.",
            color = Color.Gray,
            fontSize = 16.sp,
            lineHeight = 20.sp
        )

        // Word Count
        Row(
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Text("12", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.width(16.dp))
            Text("24", color = Color.Gray, fontSize = 16.sp)
        }

        // Recovery Phrase Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            items(recoveryWords.take(12)) { word ->
                RecoveryWordItem(
                    word = word,
                    index = recoveryWords.indexOf(word) + 1
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = { /* Handle upload */ },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color.Gray)
            ) {
                Text("Upload")
            }

            OutlinedButton(
                onClick = { /* Handle paste */ },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color.Gray)
            ) {
                Text("Paste")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Save Button
        Button(
            onClick = onSaved,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9CFF2E)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Saved Phrase",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { /* Handle existing wallet */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Use Existing Wallet",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecoveryPhraseScreen() {
    RecoveryPhraseScreen(onBack = {}, onSaved = {})
}