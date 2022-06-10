package xyz.teamgravity.containertransformtransition.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.containertransformtransition.core.extension.navigateSafely
import xyz.teamgravity.containertransformtransition.data.model.AlbumModel
import xyz.teamgravity.containertransformtransition.databinding.FragmentAlbumListBinding
import xyz.teamgravity.containertransformtransition.presentation.adapter.AlbumAdapter
import xyz.teamgravity.containertransformtransition.presentation.viewmodel.AlbumListViewModel
import javax.inject.Inject

@AndroidEntryPoint
class AlbumList : Fragment(), AlbumAdapter.AlbumListener {

    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!

    private val viewmodel by viewModels<AlbumListViewModel>()

    @Inject
    lateinit var adapter: AlbumAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview()
        observe()
    }

    private fun recyclerview() {
        binding.apply {
            recyclerview.setHasFixedSize(true)
            recyclerview.adapter = adapter
            adapter.listener = this@AlbumList
        }
    }

    private fun observe() {
        observeAlbums()
    }

    private fun observeAlbums() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.albums.collectLatest { data ->
                    adapter.submitList(data)
                }
            }
        }
    }

    override fun onAlbumClick(album: AlbumModel, view: View) {
        findNavController().navigateSafely(AlbumListDirections.actionAlbumListToAlbum(album = album))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}