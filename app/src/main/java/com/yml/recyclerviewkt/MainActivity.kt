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
        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }
        mRecyclerView = findViewById(R.id.recyclerView)
        mAdapter = WordListAdapter(this, mWordList)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //                        .setAction("Action", null).show();
            val wordListSize = mWordList.size
            mWordList.addLast("+ Word $wordListSize")
            Objects.requireNonNull(mRecyclerView.getAdapter()).notifyItemInserted(wordListSize)
            mRecyclerView.smoothScrollToPosition(wordListSize)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        if (id == R.id.action_reset) {
////            Intent i = new Intent(getApplicationContext(),MainActivity.class);
////            startActivity(i);
//            val intent = Intent(Intent.ACTION_MAIN)
//            intent.addCategory(Intent.CATEGORY_HOME)
//            startActivity(intent)
//        }
//        return super.onOptionsItemSelected(item)
//    }
}