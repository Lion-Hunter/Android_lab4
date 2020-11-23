package com.example.task2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.databinding.ItemLayoutBinding
import name.ank.lab4.BibDatabase
import name.ank.lab4.BibEntry
import name.ank.lab4.Keys
import java.io.InputStream
import java.io.InputStreamReader


class Adapter(inputStream: InputStream): RecyclerView.Adapter<ViewHolder>() {
    private var database: BibDatabase

    init {
        InputStreamReader(inputStream).use { reader ->
            database = BibDatabase(reader)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemLayoutBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindEntry(database.getEntry(position))
    }

    override fun getItemCount(): Int {
        return database.size()
    }
}