package org.cream.udemshoppingproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

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
        // 람다식 하나의 식일떄는 람다식으로
        button.setOnClickListener {
           val transaction = parentFragmentManager.beginTransaction()
            transaction.add(R.id.container_main,ProductDetailFragment())
            transaction.commit()
        }
    }
}