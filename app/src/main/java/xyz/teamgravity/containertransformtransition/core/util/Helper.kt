package xyz.teamgravity.containertransformtransition.core.util

import xyz.teamgravity.containertransformtransition.R
import xyz.teamgravity.containertransformtransition.data.model.AlbumModel

object Helper {

    /**
     * Get mock albums
     */
    fun getAlbums(): List<AlbumModel> {
        val albums = mutableListOf<AlbumModel>()
        repeat(20) { index ->
            albums.add(buildAlbum(id = index))
        }
        return albums
    }

    /**
     * Build mock album
     */
    private fun buildAlbum(id: Int): AlbumModel {
        return AlbumModel(
            id = id,
            artist = "Cristiano Ronaldo",
            album = "Shut the fuck up",
            cover = R.drawable.ronaldo,
        )
    }
}