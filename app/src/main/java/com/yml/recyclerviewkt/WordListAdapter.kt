package com.yml.recyclerviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class WordListAdapter(context: Context?, wordList: LinkedList<String>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mWordList: LinkedList<String> = wordList
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val mItemView = mInflater.inflate(
            R.layout.wordlist_item,
            parent, false
        )
        return WordViewHolder(mItemView, this)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val mCurrent = mWordList[position]
        holder.wordItemView.text = mCurrent
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    inner class WordViewHolder(itemView: View, mAdapter: WordListAdapter) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val wordItemView: TextView = itemView.findViewById(R.id.word)
        val mAdapter: WordListAdapter = mAdapter
        override fun onClick(v: View) {
            val mPosition = layoutPosition
            val element = mWordList[mPosition]
            mWordList[mPosition] = "Clicked! $element"
            mAdapter.notifyDataSetChanged()
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

}
