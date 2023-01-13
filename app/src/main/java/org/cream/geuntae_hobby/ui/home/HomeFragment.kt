package org.cream.geuntae_hobby.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.cream.geuntae_hobby.*
import org.cream.geuntae_hobby.common.KEY_PRODUCT_ID
import org.cream.geuntae_hobby.databinding.FragmentHomeBinding
import org.cream.geuntae_hobby.ui.common.*

@AndroidEntryPoint
class HomeFragment : Fragment(), ProductClickListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewLifecycleOwner 란 라이프 사이클이 변경됨을 알림을 받아 알리는 것
        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setTopBanners()
        setNavigation()
        setListAdapter()
    }

    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title
        }
    }

    private fun setNavigation() {
        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver { productId ->
            findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
                KEY_PRODUCT_ID to productId
            ))
        })
    }


    private fun setTopBanners() {

        with(binding.viewpagerHomeBanner) {
            adapter = HomeBannerAdapter(viewModel).apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }
            // 스와이프를 할때 거리 값
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }

            TabLayoutMediator(binding.viewpagerHomeBannerIndicator, this) { tab, position ->

            }.attach()
        }
    }

    private fun setListAdapter() {
        val titleAdapter = SectionTitleAdapter()
        val promotionAdapter = ProductPromotionAdapter(this)

        binding.rvHome.adapter = ConcatAdapter(titleAdapter, promotionAdapter)

        viewModel.promotions.observe(viewLifecycleOwner) { promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }

    // ProductClickListener
    override fun onProductClick(productId: String) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
            KEY_PRODUCT_ID to productId
        ))
    }

}
