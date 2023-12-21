package com.example.mybank

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybank.data.FinanceSectionItems
import com.example.mybank.ui.theme.*

val financeItems = listOf(

    FinanceSectionItems(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        bgColor = orangeStart
    ),

    FinanceSectionItems(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        bgColor = blueStart
    ),

    FinanceSectionItems(
        icon = Icons.Rounded.Analytics,
        name = "Finance\nAnalysis",
        bgColor = purpleStart
    ),

    FinanceSectionItems(
        icon = Icons.Rounded.Money,
        name = "My\nTransactions",
        bgColor = greenEnd
    )
)

@Composable
fun FinanceSection() {
    Column{
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        //Spacer(modifier = Modifier.height(10.dp))

        LazyRow {
            items(financeItems.size) {
                Finance(it)
            }
        }
    }
}

@Composable
fun Finance(index : Int) {
    val finance = financeItems[index]
    var lastItemPaddingEnd = 0.dp

    if (index == financeItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {  }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.bgColor)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }

}