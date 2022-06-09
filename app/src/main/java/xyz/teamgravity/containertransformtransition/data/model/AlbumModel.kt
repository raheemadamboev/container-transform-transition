package xyz.teamgravity.containertransformtransition.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumModel(
    val id: Int,
    val artist: String,
    val album: String,
    @DrawableRes val cover: Int,
) : Parcelable
