package ph.edu.delacruz_lab2_business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ph.edu.delacruz_lab2_business_card.ui.theme.DelaCruz_Lab2BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DelaCruz_Lab2BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        color = Color(0xFFF5F5F5)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, color: Any) {
    var message by remember { mutableStateOf("Hello! 👋") }
    var isFirstImage by remember { mutableStateOf(true) } // <-- FIX: declare state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Box ensures only one image is visible
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            if (isFirstImage) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Profile picture",
                    modifier = Modifier.size(110.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.avatar2),
                    contentDescription = "Profile picture",
                    modifier = Modifier.size(110.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
            text = "Ryan Erich R. Dela Cruz",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333)
        )

        // Role / Title
        Text(
            text = "Android Developer Student",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Contact Info
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "📧 Email: ryanerichdelacruz@email.com", fontSize = 16.sp)
            Text(text = "📱 Phone: +63 9567156265", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        //Button
        Button(
            onClick = {
                isFirstImage = !isFirstImage
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Text(text = "Change Picture", color = Color.White)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DelaCruz_Lab2BusinessCardTheme {
//        Greeting("Android")
//    }
//}