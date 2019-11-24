package com.developer.eduica

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    private lateinit var layouts: Array<Int>
    private lateinit var viewPagerAdapter: MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        layouts = arrayOf(
            R.layout.onboarding_1,
            R.layout.onboarding_2,
            R.layout.onboarding_3,
            R.layout.onboarding_4
        )
        viewPagerAdapter = MyViewPagerAdapter(layouts, applicationContext)

        addBottomDots(0)

        view_pager.adapter = viewPagerAdapter
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }
        })
    }

    private fun addBottomDots(position: Int) {
        linear_dots.removeAllViews()

        for (pos in 1..viewPagerAdapter.count) {
            val txt = TextView(this)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                txt.text = Html.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
            } else {
                @Suppress("DEPRECATION")
                txt.text = Html.fromHtml("&#8226;")

            }
            txt.textSize = 35f
            txt.setTextColor(ContextCompat.getColor(this, R.color.inactive_dot))

            if (pos - 1 == position)
                txt.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))

            linear_dots.addView(txt)
        }
    }

    class MyViewPagerAdapter(
        private val layouts: Array<Int>,
        private val context: Context
    ) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater.inflate(layouts[position], container, false)

            container.addView(view)
            return view
        }

        override fun isViewFromObject(view: View, `object`: Any) = (view == `object`)

        override fun getCount(): Int = layouts.size

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }

    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyLongPress(keyCode, event)
    }
}
