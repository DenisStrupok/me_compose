package com.me.features.weather

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.me.R
import com.me.styles.TextBlackBold16

@Composable
fun WeatherScreen(
    vm: WeatherVM = hiltViewModel(),
    actionBack: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        actionBack?.invoke()
                    }
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = stringResource(id = R.string.weather_screen_title),
                style = TextBlackBold16
            )
            Spacer(modifier = Modifier.weight(1F))
        }
    }
}