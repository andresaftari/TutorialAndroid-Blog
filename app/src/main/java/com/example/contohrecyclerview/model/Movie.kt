package com.example.contohrecyclerview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var poster: Int,
    var title: String?,
    var genre: String?
) : Parcelable