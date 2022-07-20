package br.com.zup.movieflix.moviedetail.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DirectorModel(
    var name: String,
    var info: String
) : Parcelable