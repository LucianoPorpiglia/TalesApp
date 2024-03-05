import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.storiesapp.R

@Composable
fun BrushedImage(imageId: Int) {
    Image(
        painterResource(
            id = imageId
        ),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    )
}


@Composable
fun PriceBox(
    number: String,
    text: String,
    price: String,
    save: String,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(width = 120.dp, height = if (!isExpanded) 155.dp else 207.dp)
            .background(Color.White)
            .border(
                if (!isExpanded) 0.dp else 5.dp,
                color = if (!isExpanded) Color.Transparent else MaterialTheme.colorScheme.primary,
                shape = if (!isExpanded) RoundedCornerShape(0.dp) else RoundedCornerShape(
                    10.dp
                )
            )
            .clickable {
                onClick()
            }
    ) {

        Text(
            text = number,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = if (isExpanded && text == "Yearly") {
                        45.dp
                    } else if (isExpanded && text == "Tales") {
                        30.dp
                    } else if (isExpanded && text == "Monthly") {
                        15.dp
                    } else {
                        0.dp
                    }
                ),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = if (isExpanded && text == "Yearly") {
                        90.dp
                    } else if (isExpanded && text == "Tales") {
                        80.dp
                    } else if (isExpanded && text == "Monthly") {
                        65.dp
                    } else {
                        50.dp
                    }
                )
                .fillMaxWidth(),
            color = Color.Gray,
            style = MaterialTheme.typography.titleSmall
        )
        Divider(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = if (isExpanded && text == "Yearly") {
                        120.dp
                    } else if (isExpanded && text == "Tales") {
                        115.dp
                    } else if (isExpanded && text == "Monthly") {
                        100.dp
                    } else {
                        80.dp
                    }
                ),
            color = Color.Gray
        )
        Text(
            text = price,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = if (isExpanded && text == "Yearly") {
                        130.dp
                    } else if (isExpanded && text == "Tales") {
                        130.dp
                    } else if (isExpanded && text == "Monthly") {
                        110.dp
                    } else {
                        90.dp
                    }
                )
                .fillMaxWidth(),
            color = Color.Gray,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
        )
        Text(
            text = save,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = if (isExpanded && text == "Yearly") {
                        165.dp
                    } else if (isExpanded && text == "Monthly") {
                        145.dp
                    } else {
                        125.dp
                    }
                )
                .fillMaxWidth(),
            color = Color(0xFF7D3700),
            style = MaterialTheme.typography.bodySmall,
        )
        if (text == "Yearly" && isExpanded)
            Divider(
                modifier = Modifier
                    .height(50.dp)
                    .padding(top = 16.dp),
                color = MaterialTheme.colorScheme.primary
            )
        if (text == "Yearly" && isExpanded)
            Text(
                text = "MOST POPULAR",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp, top = 22.dp),
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleSmall
            )
    }
}

@Composable
fun TextBottom(text1: String, text2: String) {
    Text(
        text = text1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 640.dp),
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = text2,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 665.dp),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun LargeText(
    text: String,
    padding: PaddingValues
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontSize = 48.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        textAlign = TextAlign.Center
    )
}

@Composable
fun NormalText(
    text: String,
    padding: PaddingValues
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun PrimaryButton(
    padding: PaddingValues,
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = text,
            style = textStyle,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 22.sp
        )
    }
}
