package org.cream.udemshoppingproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)

        button.setOnClickListener {
            // 네비게이션_액티비티에서 프래그먼트 이동을 설정한 후
            // 버튼을 클릭스 해당 프래그먼트로 이동하는 것
           findNavController().navigate(R.id.action_navigation_home_to_productDetailFragment)
        }
    }
}