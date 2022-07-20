package br.com.zup.movieflix.moviedetail.model

import br.com.zup.movieflix.home.model.Movie

data class MovieWithDirectorModel(
    val director : DirectorModel,
    val movie : Movie
)
