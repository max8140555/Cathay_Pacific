package com.max.cathay_pacific.main

import androidx.fragment.app.Fragment
import com.max.cathay_pacific.first.FirstFragment
import com.max.cathay_pacific.second.SecondFragment

enum class MainPage(val tabName: String) {
    PAGE_ONE("分頁1") {
        override fun createFragment(): Fragment {
            return FirstFragment.newInstance()
        }
    },
    PAGE_TWO("分頁2") {
        override fun createFragment(): Fragment {
            return SecondFragment.newInstance()
        }
    };

    abstract fun createFragment(): Fragment

    companion object {
        fun getMainPageFromPosition(position: Int): MainPage {
            return if (PAGE_ONE.ordinal == position) {
                PAGE_ONE
            } else {
                PAGE_TWO
            }
        }
    }

}