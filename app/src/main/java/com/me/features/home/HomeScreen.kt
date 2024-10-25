package com.me.features.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.domain.models.HomeNavItem
import com.me.R

@Composable
fun HomeScreen(
    vm: HomeVM = hiltViewModel(),
    actionNavItemClick: ((String) -> Unit)? = null
) {

    val state = vm.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        GridList(state.value.items,
            actionItemClcik = { title ->
                actionNavItemClick?.invoke(title)
            })
    }
}

@Composable
fun GridList(items: MutableList<HomeNavItem>?, actionItemClcik: ((String) -> Unit)? = null) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items?.size ?: 0) { index ->
            val item = items?.get(index)
            item?.let {
                NavItemContainer(item = it,
                    actionItemClcik = { title ->
                        actionItemClcik?.invoke(title)
                    })
            }
        }
    }
}

@Composable
fun NavItemContainer(item: HomeNavItem, actionItemClcik: ((String) -> Unit)? = null) {
    Column(
        modifier = Modifier
            .clickable {
                actionItemClcik?.invoke(item.title)
            }
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.black),
                            colorResource(id = R.color.yellow)
                        )
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = item.icon), contentDescription = null)
        Text(text = item.title)
        Spacer(modifier = Modifier.width(16.dp))
    }
}