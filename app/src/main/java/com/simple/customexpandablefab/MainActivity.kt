package com.simple.customexpandablefab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.simple.customexpandablefab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var addButtonClicked = false

    private val rotateOpenAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_animation)}
    private val rotateCloseAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_close_animation)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButtonAdd.setOnClickListener {
            onAddButtonClicked()
        }
    }

    private fun onAddButtonClicked() {
        setAnimation(addButtonClicked)

        if (!addButtonClicked){
            addButtonClicked = true
        }else{
            addButtonClicked = false
        }
    }

    private fun setAnimation(buttonClicked: Boolean) {
        if (buttonClicked) {
            binding.floatingActionButtonAdd.startAnimation(rotateOpenAnimation)
        } else {
            binding.floatingActionButtonAdd.startAnimation(rotateCloseAnimation)
        }
    }
}