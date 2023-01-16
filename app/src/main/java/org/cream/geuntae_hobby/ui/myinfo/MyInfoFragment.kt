package org.cream.geuntae_hobby.ui.myinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.cream.geuntae_hobby.R
import org.cream.geuntae_hobby.databinding.FragmentMyinfoBinding

@AndroidEntryPoint
class MyInfoFragment : Fragment() {

    private val viewModel: MyInfoViewModel by viewModels()
    private lateinit var binding: FragmentMyinfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMyinfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        navigateToWithClickFragment()
    }

    private fun navigateToWithClickFragment() {
        binding.searchResultDetailBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_myinfo_to_detailsFragment)
        }

        binding.searchResultSaveBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_myinfo_to_settingFragment)
        }

    }


}