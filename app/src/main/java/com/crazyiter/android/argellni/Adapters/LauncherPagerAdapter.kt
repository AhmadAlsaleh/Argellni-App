package com.crazyiter.android.argellni.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class LauncherPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager)  {

    private val mFragments: MutableList<Fragment> = mutableListOf()

    fun addFragment(fragment: Fragment) {
        mFragments.add(fragment)
    }

    override fun getItem(p0: Int): Fragment = mFragments[p0]

    override fun getCount(): Int = mFragments.size

}