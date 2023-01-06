package org.cream.geuntae_hobby.ui.myinfodetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.cream.geuntae_hobby.R
import org.cream.geuntae_hobby.common.KEY_CATEGORY_ID
import org.cream.geuntae_hobby.common.KEY_CATEGORY_LABEL
import org.cream.geuntae_hobby.databinding.FragmentMyinfodetailsBinding
import org.cream.geuntae_hobby.ui.category.CategoryAdapter
import org.cream.geuntae_hobby.ui.category.CategoryViewModel
import org.cream.geuntae_hobby.ui.common.EventObserver

@AndroidEntryPoint
class MyInfoDetailsFragment : Fragment() {

    private val viewModel : MyInfoDetailsViewModel by viewModels()
    private lateinit var binding: FragmentMyinfodetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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