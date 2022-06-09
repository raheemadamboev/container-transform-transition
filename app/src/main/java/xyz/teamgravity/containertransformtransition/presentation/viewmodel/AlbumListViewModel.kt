package xyz.teamgravity.containertransformtransition.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import xyz.teamgravity.containertransformtransition.core.util.Helper
import xyz.teamgravity.containertransformtransition.data.model.AlbumModel
import javax.inject.Inject

@HiltViewModel
class AlbumListViewModel @Inject constructor(
) : ViewModel() {

    private val _albums = MutableStateFlow(Helper.getAlbums())
    val albums: StateFlow<List<AlbumModel>> = _albums.asStateFlow()
}