package com.example.praktikum7_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.praktikum7_1.databinding.ActivityMainBinding
import java.text.ParsePosition

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageAdapter
    private val listGambar = ArrayList<ImageData>()
    private lateinit var dots : ArrayList<TextView>
    private val sliderHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listGambar.add(
            ImageData(
                imgUrl = "https://images.unsplash.com/photo-1669072551428-d85c57da92bd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwyMnx8fGVufDB8fHx8&auto=format&fit=crop&w=500&q=60"
            )
        )
        listGambar.add(
            ImageData(
                imgUrl = "https://images.unsplash.com/photo-1475503572774-15a45e5d60b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80"
            )
        )
        listGambar.add(
            ImageData(
                imgUrl = "https://images.unsplash.com/photo-1669058665299-d6f81125dce7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
            )
        )
        listGambar.add(
            ImageData(
                imgUrl = "https://images.unsplash.com/photo-1669094482580-db99d9376352?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80"
            )
        )
        listGambar.add(
            ImageData(
                imgUrl = "https://images.unsplash.com/photo-1668933662187-5e3d1e21d29b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=715&q=80"
            )
        )
        adapter = ImageAdapter(listGambar)
        binding.vpGambar.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.vpGambar.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

    }

    private val slideRun = Runnable {
        binding.vpGambar.currentItem = binding.vpGambar.currentItem + 1
    }

    private fun  selectDot(position: Int){
        for(i in 0 until  listGambar.size){
            if(i==position){
                dots[i].setTextColor(ContextCompat.getColor(this,com.google.android.material.R.color.design_default_color_on_primary))
            }else{
                dots[i].setTextColor(ContextCompat.getColor(this,com.google.android.material.R.color.design_default_color_on_secondary))
            }
        }
    }

    private fun setIndicator() {
        for(i in 0 until listGambar.size){
            dots.add(TextView(this))
            dots[i].text = Html.fromHtml("&#9679",Html.FROM_HTML_MODE_LEGACY).toString()

            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }
}
