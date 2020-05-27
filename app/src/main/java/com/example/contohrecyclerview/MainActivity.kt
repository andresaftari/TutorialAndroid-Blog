package com.example.contohrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contohrecyclerview.model.Movie
import com.example.contohrecyclerview.util.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Movie>()

    companion object {
        private const val STATE_LIST = "state_list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "HOME"

        when (savedInstanceState) {
            null -> {
                list.addAll(getListMovies())
                setRecyclerView()
            }
            else -> {
                val stateList =
                    savedInstanceState.getParcelableArrayList<Movie>(STATE_LIST)

                if (stateList != null) list.addAll(stateList)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(STATE_LIST, list)
    }

    @SuppressLint("Recycle")
    private fun getListMovies(): ArrayList<Movie> {
        val dataPhoto = resources.obtainTypedArray(R.array.poster)
        val dataTitle = resources.getStringArray(R.array.title_name)
        val dataGenre = resources.getStringArray(R.array.genre_name)

        val listMovie = ArrayList<Movie>()
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataTitle[position],
                dataGenre[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun setRecyclerView() {
        rv_main?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(list)
        }
    }
}
