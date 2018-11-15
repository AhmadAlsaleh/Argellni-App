package com.crazyiter.android.argellni

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Toast
import com.crazyiter.android.argellni.Adapters.LauncherPagerAdapter
import com.crazyiter.android.argellni.LauncherFragments.FirstFragment
import com.crazyiter.android.argellni.LauncherFragments.SecondFragment
import com.crazyiter.android.argellni.LauncherFragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val isFirst = getSharedPreferences("isFirst", Context.MODE_PRIVATE)
        if (isFirst.getBoolean("showMain", false)) {
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        } else {
            val editIsFirst = isFirst.edit()
            editIsFirst.putBoolean("showMain", true)
            editIsFirst.apply()
            setupPager()
        }

    }

    private fun setupPager() {
        val adapter = LauncherPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment())
        adapter.addFragment(SecondFragment())
        adapter.addFragment(ThirdFragment())
        launcherVP.adapter = adapter

        launcherNextBTN.setOnClickListener {
            launcherVP.currentItem++
        }

        launcherContinueBTN.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        }

        launcherSignInBTN.setOnClickListener {
            Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show()
        }

        launcherVP.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {}
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

            override fun onPageSelected(p0: Int) {
                if (p0 == 2) {
                    launcherNextBTN.visibility = View.GONE
                    launcherLastBTNs.visibility = View.VISIBLE
                } else {
                    launcherNextBTN.visibility = View.VISIBLE
                    launcherLastBTNs.visibility = View.GONE
                }
            }

        })

    }

}
