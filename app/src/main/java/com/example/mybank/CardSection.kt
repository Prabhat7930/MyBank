package com.example.mybank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.data.CardSectionItems
import com.example.mybank.ui.theme.*

val cardItems = listOf(
    CardSectionItems(
        cardType = "VISA",
        cardNumber = "6478 3215 5809 6446",
        cardName = "Business",
        cardBalance = 42.235,
        color = getGradient(purpleStart, purpleEnd)
    ),

    CardSectionItems(
        cardType = "MasterCard",
        cardNumber = "5773 3127 0797 8663",
        cardName = "Business",
        cardBalance = 12.253,
        color = getGradient(blueStart, blueEnd)
    ),

    CardSectionItems(
        cardType = "RuPay",
        cardNumber = "2409 8643 5742 5682",
        cardName = "Savings",
        cardBalance = 83.486,
        color = getGradient(orangeStart, orangeEnd)
    ),

    CardSectionItems(
        cardType = "VISA",
        cardNumber = "2367 6832 1356 4861",
        cardName = "Credit",
        cardBalance = 357.235,
        color = getGradient(greenStart, greenEnd)
    )
)

fun getGradient(
    startColor : Color,
    endColor : Color
) : Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardSection() {
    LazyRow {
        items(cardItems.size) {
            Card(it)
        }
    }
}


@Composable
fun Card(index : Int) {
    val card = cardItems[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cardItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.visa)
    if (card.cardType == "MasterCard") {
        image = painterResource(id = R.drawable.mastercard)
    }
    else if (card.cardType == "RuPay") {
        image = painterResource(id = R.drawable.rupay)
    }

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 5.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardBalance.toString(),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}