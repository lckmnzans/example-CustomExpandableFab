package com.simple.customexpandablefab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.simple.customexpandablefab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var addButtonClicked = false

    private val rotateOpenAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_animation)}
    private val rotateCloseAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.rotate_close_animation)}
    private val fromBottomAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.from_bottom_animation)}
    private val toBottomAnimation: Animation by lazy {AnimationUtils.loadAnimation(this, R.anim.to_bottom_animation)}

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
        setVisibility(addButtonClicked)
        buttonSetClickable()

        addButtonClicked = !addButtonClicked
    }

    private fun setAnimation(buttonClicked: Boolean) {
        if (buttonClicked) {
            binding.apply {
                floatingActionButtonAdd.startAnimation(rotateOpenAnimation)
                floatingActionButtonCall.startAnimation(fromBottomAnimation)
                floatingActionButtonMessage.startAnimation(fromBottomAnimation)
            }
        } else {
            binding.apply {
                floatingActionButtonAdd.startAnimation(rotateCloseAnimation)
                floatingActionButtonCall.startAnimation(toBottomAnimation)
                floatingActionButtonMessage.startAnimation(toBottomAnimation)
            }
        }
    }

    private fun setVisibility(buttonClicked: Boolean) {
        if (!buttonClicked){
            binding.floatingActionButtonCall.visibility = VISIBLE
            binding.floatingActionButtonMessage.visibility = VISIBLE
        } else {
            binding.floatingActionButtonCall.visibility = INVISIBLE
            binding.floatingActionButtonMessage.visibility = INVISIBLE
        }
    }

    private fun buttonSetClickable() {
        if (addButtonClicked){
            binding.floatingActionButtonCall.isClickable = true
            binding.floatingActionButtonMessage.isClickable = true
        } else {
            binding.floatingActionButtonCall.isClickable = false
            binding.floatingActionButtonMessage.isClickable = false
        }
    }
}