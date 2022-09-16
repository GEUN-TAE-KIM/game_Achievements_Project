package org.cream.udemshoppingproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import org.cream.udemshoppingproject.GlideApp
import org.cream.udemshoppingproject.HomData
import org.cream.udemshoppingproject.R
import org.cream.udemshoppingproject.Title
import org.cream.udemshoppingproject.assets.AssetLoder

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        val assetLoader = AssetLoder()
        //requireContext를 하는 건 context가 널러블이기 떄문
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home,json")
        Log.d("homeData", homeJsonString ?: "")

        //json 데이터 파싱
        if (!homeJsonString.isNullOrEmpty()) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomData::class.java)

            //viewLifecycleOwner 란 라이프 사이클이 변경됨을 알림을 받아 알리는 것
            viewModel.title.observe(viewLifecycleOwner) { title ->
                toolbarTitle.text =title.text
                GlideApp.with(this)
                    .load(title.iconUrl)
                    .into(toolbarIcon)
            }

            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                viewpager.adapter = HomeBannerAdapter().apply {
                    submitList(homeData.topBanners)
                }
            }

            // 스와이프를 할때 거리 값
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            viewpager.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }

            TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position ->

            }.attach()


        }
    }
}