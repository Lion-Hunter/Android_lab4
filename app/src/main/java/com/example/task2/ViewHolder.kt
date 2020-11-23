package com.example.task2

import androidx.recyclerview.widget.RecyclerView
import com.example.task2.databinding.ItemLayoutBinding
import name.ank.lab4.BibEntry
import name.ank.lab4.Keys

class ViewHolder(private  val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindEntry(entry: BibEntry) {
        binding.author.text = entry.getField(Keys.AUTHOR)
        binding.title.text = entry.getField(Keys.TITLE)
        binding.year.text = entry.getField(Keys.YEAR)
    }
}