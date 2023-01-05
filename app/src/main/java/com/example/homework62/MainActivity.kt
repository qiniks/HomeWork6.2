package com.example.homework62

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework62.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var imageList: ArrayList<Int> = arrayListOf()
    private var selectedImages:  ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()

        val selectedAdapter = SelectedAdapter(list = imageList, this::selectedListener, this::deleteListener)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = selectedAdapter
        }

        initClick()
    }

    private fun initClick() {
        binding.btnSend.setOnClickListener {
            Intent(this, SecondActivity::class.java).apply {
                putIntegerArrayListExtra(SELECTED_IMAGES, selectedImages)
                startActivity(this)
            }
        }
    }

    private fun deleteListener(url: Int) {
        selectedImages.remove(imageList[imageList.indexOf(url)])
    }

    private fun selectedListener(url: Int) {
        selectedImages.add(imageList[imageList.indexOf(url)])
    }

    private fun fillList() {
        imageList = arrayListOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,

            R.drawable.img2,
            R.drawable.img4,
            R.drawable.img1,
            R.drawable.img3,
            R.drawable.img6,
            R.drawable.img5,

            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img1,
            R.drawable.img6,
            R.drawable.img5,
            R.drawable.img4,
        )
    }

    companion object {
        const val SELECTED_IMAGES = "key"
    }

}