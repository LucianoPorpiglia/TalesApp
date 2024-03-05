
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storiesapp.R

@Composable
fun BlurBox(
    titleText: String,
    descText: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp)
    ) {
        Box(
            modifier = Modifier
                .size(370.dp, 147.dp)
                .background(
                    color = Color(0x80747070),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                text = titleText,
                modifier = Modifier.padding(start = 15.dp),
                color = Color.White,
                fontWeight = FontWeight(700),
                lineHeight = 32.sp,
                fontSize = 36.sp,
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = descText,
                modifier = Modifier.padding(start = 15.dp, top = 80.dp),
                color = Color.White,
                fontWeight = FontWeight(400),
                lineHeight = 22.sp,
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}

@Composable
fun BlurBox2() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .size(370.dp, 147.dp)
                .background(
                    color = Color(0x80747070),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                text = "Create your own \n" +
                        "Adventure",
                modifier = Modifier.padding(start = 15.dp, top = 18.dp),
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 33.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.sf_pro_display3)),
                style = TextStyle(lineHeight = 22.sp)
            )
            Text(
                text = "",
                modifier = Modifier.padding(start = 15.dp, top = 100.dp),
                fontSize = 16.sp,
                lineHeight = 25.sp,
                color = Color(0xFFFFFFFF),
                fontFamily = FontFamily(Font(R.font.sf_pro_display)),
                style = TextStyle(lineHeight = 22.sp)
            )
        }
    }
}