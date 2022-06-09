package xyz.teamgravity.containertransformtransition.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import xyz.teamgravity.containertransformtransition.presentation.adapter.AlbumAdapter

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    @FragmentScoped
    fun provideAlbumDiff(): AlbumAdapter.AlbumDiff = AlbumAdapter.AlbumDiff

    @Provides
    @FragmentScoped
    fun provideAlbumAdapter(albumDiff: AlbumAdapter.AlbumDiff): AlbumAdapter = AlbumAdapter(diff = albumDiff)
}