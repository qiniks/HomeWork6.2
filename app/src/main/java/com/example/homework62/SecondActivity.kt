package com.example.homework62

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework62.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var imageList: ArrayList<Int> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getIntegerArrayListExtra(MainActivity.SELECTED_IMAGES)

        if (result != null) {
            imageList = result
        }

        val selectedAdapter = SelectedAdapter(list = imageList, null, null)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@SecondActivity, 3)
            adapter = selectedAdapter
        }
    }
}