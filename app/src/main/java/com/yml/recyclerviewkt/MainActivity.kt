package com.yml.recyclerviewkt

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mWordList = LinkedList<String>()
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: WordListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        populate()
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val wordListSize = mWordList.size
            mWordList.addLast("+ Word $wordListSize")
            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyItemInserted(wordListSize)
            mRecyclerView.smoothScrollToPosition(wordListSize)
        }
    }
    fun populate(){
        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }
        mRecyclerView = findViewById(R.id.recyclerView)
        mAdapter = WordListAdapter(this, mWordList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId
        if (id == R.id.action_reset) {
            startActivity(Intent(applicationContext,MainActivity::class.java))
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}