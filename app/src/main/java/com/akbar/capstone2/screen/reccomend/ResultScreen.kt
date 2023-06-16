import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akbar.capstone2.R

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier
) {
    Column(

        modifier
            .padding(16.dp)
            .verticalScroll(enabled = true, state = rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.jagung),
            contentDescription = null
        )
        Spacer(modifier = modifier.size(16.dp))
        Text(
            text = stringResource(R.string.jagung),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(R.drawable.plant),
            contentDescription = null,
            modifier
                .size(45.dp)
                .padding(16.dp)
        )
        Text(
            color = MaterialTheme.colorScheme.scrim,
            text = stringResource(R.string.deskripsi_jagung)
        )
    }
}