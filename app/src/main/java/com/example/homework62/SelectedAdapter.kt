package com.example.homework62

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework62.databinding.ImageItemBinding

class SelectedAdapter(
    private var list: ArrayList<Int>,
    private val selectedListener: ((url: Int) -> Unit)?,
    private val deleteListener: ((url: Int) -> Unit)?
) : RecyclerView.Adapter<SelectedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: Int) {

            binding.imageView.setImageResource(url)

            itemView.setOnClickListener {
                if (binding.viewBlack.visibility == View.GONE) {
                    selectedListener?.let { it1 -> it1(url) }
                    binding.viewBlack.visibility = View.VISIBLE
                } else {
                    deleteListener?.let { it1 -> it1(url) }
                    binding.viewBlack.visibility = View.GONE
                }
            }
        }
    }
}