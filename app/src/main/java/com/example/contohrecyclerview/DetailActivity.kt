package com.example.contohrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.contohrecyclerview.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "DETAIL"

        if (intent.hasExtra(EXTRA_DATA)) {
            val dataIntent = intent.getParcelableExtra(EXTRA_DATA) as Movie

            Glide.with(this)
                .load(dataIntent.poster)
                .into(iv_list_poster as ImageView)

            tv_detailTitle?.text = dataIntent.title
            tv_detailGenre?.text = dataIntent.genre
        }
    }
}
