package com.me.features.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.domain.models.HomeNavItem
import com.domain.states.HomeNavItemState
import com.me.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeNavItemState())
    val state: StateFlow<HomeNavItemState> = _state

    init {
        createNavItems()
    }
    private fun createNavItems() {
        if (state.value.items.isNullOrEmpty()) {
            var new = mutableListOf<HomeNavItem>().apply {
                this.add(
                    HomeNavItem(
                        title = "Weather",
                        icon = R.drawable.ic_weather
                    )
                )
                this.add(
                    HomeNavItem(
                        title = "Profile",
                        icon = R.drawable.ic_profile
                    )
                )
            }
            _state.value.items = new
            _state.value = _state.value
        }
    }

}