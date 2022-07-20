package br.com.zup.movieflix.moviedetail.repository

import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.DirectorModel
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorModel

class MovieDetailRepository (private val dataSource: DirectorLocalDataSource) {

    fun getMovieWithDirector(movie: Movie) : MovieWithDirectorModel{
        val listaDeDiretores = dataSource.directorList
        var diretor = DirectorModel("","")
        listaDeDiretores.forEach {
            if(it.name == movie.director){
                diretor = it
            }
        }
        return MovieWithDirectorModel(diretor,movie)
    }
}