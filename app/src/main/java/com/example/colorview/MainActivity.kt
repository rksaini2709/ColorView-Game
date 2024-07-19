package com.example.colorview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.colorview.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.box_five_text
//import kotlinx.android.synthetic.main.activity_main.box_four_text
//import kotlinx.android.synthetic.main.activity_main.box_one_text
//import kotlinx.android.synthetic.main.activity_main.box_three_text
//import kotlinx.android.synthetic.main.activity_main.box_two_text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraint_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }
    private fun setListeners() {
        val clickableViews : List<View> = listOf(
//            box_one_text,
//            box_two_text,
//            box_three_text,
//            box_four_text,
//            box_five_text

            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.constraintLayout,
            binding.buttonGreen,
            binding.buttonYellow,
            binding.buttonRed
        )

        for(item in clickableViews){
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }
    private fun makeColored(view: View) {
        when(view.id){
            R.id.box_one_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_two_text -> view.setBackgroundColor(Color.MAGENTA)

            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_purple)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_orange_light)

            R.id.button_red -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.button_yellow -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.button_green -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}