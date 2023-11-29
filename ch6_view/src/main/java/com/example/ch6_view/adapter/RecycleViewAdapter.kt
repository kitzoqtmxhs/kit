package com.example.ch6_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ch6_view.R
import com.example.ch6_view.RecycleViewItem

class RecycleViewAdapter(private val itemList: ArrayList<RecycleViewItem>) :
    RecyclerView.Adapter<RecycleViewAdapter.BoardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_community_addpost_recycleview, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.addPostTitle.text = itemList[position].title
        holder.addPostContents.text = itemList[position].contents
        holder.addPostWriter.text = itemList[position].writer

    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addPostTitle: TextView = itemView.findViewById(R.id.community_post_title)
        val addPostContents: TextView = itemView.findViewById(R.id.community_post_contents)
        val addPostWriter: TextView = itemView.findViewById(R.id.community_post_writer)
    }
}