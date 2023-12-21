package com.example.mybank


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.data.currencySectionItems

val currencyItems = listOf(
    currencySectionItems(
        name = "USD",
        buy = 325.46f,
        sell = 353.22f,
        icon = Icons.Rounded.AttachMoney
    ),

    currencySectionItems(
        name = "EUR",
        buy = 455.16f,
        sell = 753.72f,
        icon = Icons.Rounded.Euro
    ),

    currencySectionItems(
        name = "INR",
        buy = 665.35f,
        sell = 553.52f,
        icon = Icons.Rounded.CurrencyRupee
    ),

    currencySectionItems(
        name = "YEN",
        buy = 125.27f,
        sell = 163.84f,
        icon = Icons.Rounded.CurrencyYen
    ),

    currencySectionItems(
        name = "USD",
        buy = 455.49f,
        sell = 853.21f,
        icon = Icons.Rounded.AttachMoney
    ),

    currencySectionItems(
        name = "INR",
        buy = 665.64f,
        sell = 692.35f,
        icon = Icons.Rounded.CurrencyRupee
    )
)

@Composable
fun CurrencySection() {
    var isVisible1 = remember { mutableStateOf(false) }
    var iconState = remember { mutableStateOf(Icons.Rounded.KeyboardArrowUp) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible1.value = !isVisible1.value
                            iconState.value = if (!isVisible1.value) {
                                Icons.Rounded.KeyboardArrowUp
                            } else {
                                Icons.Rounded.KeyboardArrowDown
                            }
                        }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState.value,
                        contentDescription = "Currencies",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Currencies",
                    color = MaterialTheme.colorScheme.inverseSurface,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            if (isVisible1.value) {

                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.inverseSurface)
                )

                Spacer(modifier = Modifier.height(10.dp))

                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    val boxWithConstrainsSCope = this
                    val width = boxWithConstrainsSCope.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Buy",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn{
                            items(currencyItems.size) {
                                Currency(it, width)
                            }
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun Currency(index : Int, width : Dp) {
    val currency = currencyItems[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.width(width)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(7.dp))
                    .background(MaterialTheme.colorScheme.inverseSurface)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(11.5.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = MaterialTheme.colorScheme.surface
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = currency.name,
                color = MaterialTheme.colorScheme.inverseSurface,
                fontSize = 16.sp
            )
        }

        Text(
            modifier = Modifier.width(width),
            text = currency.buy.toString(),
            color = MaterialTheme.colorScheme.inverseSurface,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.width(width),
            text = currency.sell.toString(),
            color = MaterialTheme.colorScheme.inverseSurface,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}