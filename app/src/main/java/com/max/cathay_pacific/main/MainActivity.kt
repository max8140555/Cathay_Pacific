package com.max.cathay_pacific.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.viewpager2.widget.ViewPager2
import com.max.cathay_pacific.R
import com.max.cathay_pacific.databinding.ActivityMainBinding
import com.max.cathay_pacific.ext.reduceDragSensitivityBy
import com.max.cathay_pacific.ext.setupWithViewPager2
import com.max.cathay_pacific.main.MainPage.Companion.getMainPageFromPosition

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var actionBarTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        initTabLayoutAndViewPager2()
        initSwitchPageButton()
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setCustomView(R.layout.layout_custom_action_bar)
            actionBarTextView = customView.findViewById(R.id.textView_actionBar_title)
            actionBarTextView?.text = getString(R.string.online_test_a)
        }
    }

    private fun initTabLayoutAndViewPager2() {
        val mainPages = MainPage.values().toList()
        val mainPagerAdapter = MainPagerAdapter(this, mainPages)

        binding.viewPager2Main.apply {
            adapter = mainPagerAdapter
            reduceDragSensitivityBy(3)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    val mainPage = getMainPageFromPosition(position)

                    val buttonText = if (mainPage == MainPage.PAGE_ONE) {
                        getString(R.string.switch_page_two)
                    } else {
                        getString(R.string.switch_page_one)
                    }
                    binding.buttonSwitchPage.text = buttonText

                    val actionBarTitle = if (mainPage == MainPage.PAGE_ONE) {
                        getString(R.string.online_test_a)
                    } else {
                        getString(R.string.online_test_b)
                    }
                    actionBarTextView?.text = actionBarTitle
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageScrollStateChanged(state: Int) {
                }
            })
        }

        binding.tabLayoutMain.setupWithViewPager2(binding.viewPager2Main) { tab, position ->
            tab.text = mainPages[position].tabName
        }
    }

    private fun initSwitchPageButton() {
        binding.buttonSwitchPage.setOnClickListener {
            val currentMainPage = getMainPageFromPosition(binding.viewPager2Main.currentItem)
            if (currentMainPage == MainPage.PAGE_ONE) {
                binding.viewPager2Main.currentItem = MainPage.PAGE_TWO.ordinal
            } else {
                binding.viewPager2Main.currentItem = MainPage.PAGE_ONE.ordinal
            }
        }
    }

}