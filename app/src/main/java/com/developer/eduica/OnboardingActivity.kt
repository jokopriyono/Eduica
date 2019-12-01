package com.developer.eduica

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
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
        showTitleAndDesc(0)

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
                showTitleAndDesc(position)
            }
        })
    }

    private fun showTitleAndDesc(position: Int) {
        when (position) {
            0 -> {
                txt_onboard_title.text = getString(R.string.onboard_title_1)
                txt_onboard_desc.text = getString(R.string.onboard_desc_1)
                btn_finish.visibility = View.GONE
                btn_skip.visibility = View.VISIBLE
            }
            1 -> {
                txt_onboard_title.text = getString(R.string.onboard_title_2)
                txt_onboard_desc.text = getString(R.string.onboard_desc_2)
                btn_finish.visibility = View.GONE
                btn_skip.visibility = View.VISIBLE
            }
            2 -> {
                txt_onboard_title.text = getString(R.string.onboard_title_3)
                txt_onboard_desc.text = getString(R.string.onboard_desc_3)
                btn_finish.visibility = View.GONE
                btn_skip.visibility = View.VISIBLE
            }
            else -> {
                txt_onboard_title.text = getString(R.string.onboard_title_4)
                txt_onboard_desc.text = getString(R.string.onboard_desc_4)
                btn_finish.visibility = View.VISIBLE
                btn_skip.visibility = View.GONE
            }
        }
    }

    private fun addBottomDots(position: Int) {
        linear_dots.removeAllViews()

        for (pos in 1..viewPagerAdapter.count) {
            val img = ImageView(this)
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            lp.setMargins(15, 0, 15, 0)
            img.layoutParams = lp

            if (pos - 1 == position)
                img.setImageResource(R.drawable.ic_dot_active)
            else
                img.setImageResource(R.drawable.ic_dot_inactive)
            linear_dots.addView(img)
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
