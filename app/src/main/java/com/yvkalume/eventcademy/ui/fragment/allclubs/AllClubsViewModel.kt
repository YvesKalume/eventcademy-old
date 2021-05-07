package com.yvkalume.eventcademy.ui.fragment.allclubs

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.yvkalume.data.mapper.ClubUiMapper
import com.yvkalume.domain.usecase.club.GetAllClubUseCase
import com.yvkalume.eventcademy.di.mavericks.AssistedViewModelFactory
import com.yvkalume.eventcademy.di.mavericks.hiltMavericksViewModelFactory
import com.yvkalume.util.data
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AllClubsViewModel @AssistedInject constructor (@Assisted state: AllClubsViewState, private val getAllClubUseCase: GetAllClubUseCase) : MavericksViewModel<AllClubsViewState>(state) {
    init {
        getAllClubs()
    }

    private fun getAllClubs() = viewModelScope.launch {
        getAllClubUseCase(Unit).map {
            it.data!!.map { club -> ClubUiMapper().map(club) }
        }.execute {
            copy(clubs = it)
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<AllClubsViewModel, AllClubsViewState> {
        override fun create(state: AllClubsViewState): AllClubsViewModel
    }

    companion object : MavericksViewModelFactory<AllClubsViewModel,AllClubsViewState> by hiltMavericksViewModelFactory()
}