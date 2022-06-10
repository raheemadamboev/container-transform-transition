package xyz.teamgravity.containertransformtransition.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import xyz.teamgravity.containertransformtransition.databinding.FragmentAlbumBinding

class Album : Fragment() {

    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<AlbumArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
        button()
    }

    private fun updateUI() {
        binding.apply {
            toolbar.title = args.album.artist
            imageI.setImageResource(args.album.cover)
            artistT.text = args.album.artist
            albumT.text = args.album.album
        }
    }

    private fun button() {
        onBack()
    }

    private fun onBack() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}