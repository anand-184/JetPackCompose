package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Header Text
        Text(
            text = "Profile Screen - ConstraintLayout",
            color = Color(0xFF1E88E5),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 24.dp)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 16.dp, end = 16.dp)
        ) {
            val (btn1, btn2, btn3, btn4) = createRefs()

            // Button 1 - Full Width
            Button(
                onClick = { },
                modifier = Modifier
                    .constrainAs(btn1) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text("Button 1")
            }

            // Button 2 and 3 - Side by side in horizontal chain
            Button(
                onClick = { },
                modifier = Modifier
                    .constrainAs(btn2) {
                        top.linkTo(btn1.bottom, margin = 20.dp)
                        bottom.linkTo(btn4.top, margin = 20.dp)
                    }
            ) {
                Text("Button 2")
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .constrainAs(btn3) {
                        top.linkTo(btn1.bottom, margin = 20.dp)
                        bottom.linkTo(btn4.top, margin = 20.dp)
                    }
            ) {
                Text("Button 3")
            }

            // Create a horizontal chain for btn2 and btn3
            createHorizontalChain(btn2, btn3, chainStyle = ChainStyle.SpreadInside)

            // Button 4 - Bottom aligned
            Button(
                onClick = { },
                modifier = Modifier
                    .constrainAs(btn4) {
                        bottom.linkTo(parent.bottom, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text("Button 4")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}
