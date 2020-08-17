package com.hr.viewpager2x

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.hr.viewpager2x.fragment.RotateFragment
import com.hr.viewpager2x.fragment.ScaleFragment
import com.hr.viewpager2x.fragment.TranslateFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FragmentStatePageAdapter适用于Fragment较多的情况
//        ragmentPageAdapter则适用于固定的，少量的Fragment情况，例如和TabLayout共同使
        viewPager2.adapter = object :FragmentStateAdapter(this) {
            override fun getItemCount() = 3

            override fun createFragment(position: Int) =
                 when(position) {
                    0 -> ScaleFragment()
                    1 -> RotateFragment()
                    else -> TranslateFragment()
                }

        }

        //联动
        TabLayoutMediator(tabLayout,viewPager2, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when(position) {
                0 -> tab.text = "缩放"
                1 -> tab.text = "旋转"
                else -> tab.text = "移动"
            }
        }).attach()

    }
}