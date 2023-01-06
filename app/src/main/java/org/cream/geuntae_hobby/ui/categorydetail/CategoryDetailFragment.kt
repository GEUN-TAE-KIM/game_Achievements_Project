package org.cream.geuntae_hobby.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import dagger.hilt.android.AndroidEntryPoint
import org.cream.geuntae_hobby.R
import org.cream.geuntae_hobby.common.KEY_CATEGORY_ID
import org.cream.geuntae_hobby.common.KEY_CATEGORY_LABEL
import org.cream.geuntae_hobby.common.KEY_PRODUCT_ID
import org.cream.geuntae_hobby.databinding.FragmentCategoryDetailBinding
import org.cream.geuntae_hobby.ui.common.ProductClickListener
import org.cream.geuntae_hobby.ui.common.ProductPromotionAdapter
import org.cream.geuntae_hobby.ui.common.SectionTitleAdapter

@AndroidEntryPoint
class CategoryDetailFragment : Fragment(), ProductClickListener {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels()

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
        binding.viewModel = viewModel

        requireArguments().getString(KEY_CATEGORY_ID)?.let { categoryId ->
            setListAdapter(categoryId)
        }

        setToolbar()

    }

    private fun setToolbar() {
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel

    }

    private fun setListAdapter(categoryId: String) {

        viewModel.loadCategoryDetail(categoryId)

        val topSellingSectionAdapter = CategoryTopSellingSectionAdapter()
        val titleAdapter = SectionTitleAdapter()
        val promotionAdapter = ProductPromotionAdapter(this)

        // 어댑터를 하나로 만드는 것
        binding.rvCategoryDetail.adapter =
            ConcatAdapter(topSellingSectionAdapter, titleAdapter, promotionAdapter)

        viewModel.topSelling.observe(viewLifecycleOwner) { topSelling ->
            topSellingSectionAdapter.submitList(listOf(topSelling))
        }

        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }

    // ProductClickListener
    override fun onProductClick(productId: String) {
        findNavController().navigate(
            R.id.action_navigation_category_detail_to_productDetailFragment2, bundleOf(
            KEY_PRODUCT_ID to "melrina-EldenRing-1"
        ))
    }

}