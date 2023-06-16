package com.akbar.capstone2.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akbar.capstone2.R
import com.akbar.capstone2.model.ProductModel

@Composable
fun ProductItem(
    image: Int,
    title: String,
    price: Int,
    modifier: Modifier = Modifier,
) {
    Card (
        modifier = modifier.width(180.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        Column {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(8.dp)){
                Text(
                    text = title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = modifier.height(1.dp))
                Text(
                    text = "Rp.${price}",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ProductItemPreview() {
    MaterialTheme {
        ProductModel(id = 1, image = R.drawable.product1, title = "Pupuk POC NASA 250 ml - nutrisi organik cair tanaman", price = 50000 , description = "R.string.lorem_ipsum")
    }
}