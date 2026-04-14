package com.example.uppgift1


//Skapad av Carlo 2025-03-20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "hem") {
                composable("hem") {
                    HemSkarm(onLasMerKlick = { navController.navigate("lasmer") })
                }
                composable("lasmer") {
                    LasMerSkarm()
                }
            }
        }
    }
}

@Composable
fun HemSkarm(onLasMerKlick: () -> Unit) {
    val blaFarg = Color(0xFF69B4E0)
    val rodFarg = Color(0xFFC0392B)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blaFarg)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .background(rodFarg)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "RUBRIK", fontSize = 32.sp, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 24.dp, horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(70.dp).background(rodFarg),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "1", fontSize = 24.sp, color = Color.Black)
            }
            Box(
                modifier = Modifier.size(70.dp).background(rodFarg),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "2", fontSize = 24.sp, color = Color.Black)
            }
            Box(
                modifier = Modifier.size(70.dp).background(rodFarg),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "3", fontSize = 24.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onLasMerKlick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3246E8),
                contentColor = Color.Black
            )
        ) {
            Text(text = "Läs mer", fontSize = 24.sp)
        }
    }
}

@Composable
fun LasMerSkarm() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Läs mer", fontSize = 32.sp)
    }
}