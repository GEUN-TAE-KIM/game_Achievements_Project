package org.cream.udemshoppingproject.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import org.cream.udemshoppingproject.common.KEY_CATEGORY_ID
import org.cream.udemshoppingproject.common.KEY_CATEGORY_LABEL
import org.cream.udemshoppingproject.databinding.FragmentCategoryDetailBinding
import org.cream.udemshoppingproject.ui.common.ViewModelFactory

class CategoryDetailFragment: Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

       setToolbar()
       setListAdapter()

    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }

    private fun setListAdapter() {

        val titleAdapter = CategorySectionTitleAdapter()
        val promotionAdapter = CategoryPromotionAdapter()
                                            // 어댑터를 하나로 만드는 것
        binding.rvCategoryDetail.adapter = ConcatAdapter(titleAdapter, promotionAdapter)

        viewModel.promotions.observe(viewLifecycleOwner) {promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }

}