package org.cream.geuntae_hobby.ui.myinfodetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.cream.geuntae_hobby.databinding.FragmentMyinfodetailsBinding

@AndroidEntryPoint
class MyInfoDetailsFragment : Fragment() {

    private val viewModel: MyInfoDetailsViewModel by viewModels()
    private lateinit var binding: FragmentMyinfodetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMyinfodetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setListAdapter()

    }

    private fun setListAdapter() {
        val myInfoDetailsAdapter = MyInfoDetailsAdapter(viewModel)
        binding.rvCategoryList.adapter = myInfoDetailsAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            myInfoDetailsAdapter.submitList(it)
        }
    }

}