package org.cream.geuntae_hobby.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import org.cream.geuntae_hobby.common.KEY_CATEGORY_LABEL
import org.cream.geuntae_hobby.databinding.FragmentCategoryDetailBinding
import org.cream.geuntae_hobby.ui.common.ProductClickListener
import org.cream.geuntae_hobby.ui.common.ProductPromotionAdapter
import org.cream.geuntae_hobby.ui.common.SectionTitleAdapter
import org.cream.geuntae_hobby.ui.common.ViewModelFactory

class CategoryDetailFragment: Fragment(), ProductClickListener {

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

        val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = SectionTitleAdapter()
        val promotionAdapter = ProductPromotionAdapter(this)
                                            // 어댑터를 하나로 만드는 것
        binding.rvCategoryDetail.adapter = ConcatAdapter(topSellingSectionAdapter,titleAdapter, promotionAdapter)
        viewModel.topSelling.observe(viewLifecycleOwner) {
            topSelling ->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }

        viewModel.promotions.observe(viewLifecycleOwner) {promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }

    // ProductClickListener
    override fun onProductClick(productId: String) {
        // TODO 화면 이동 구현
    }

}