package br.com.zup.movieflix.moviedetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorModel
import br.com.zup.movieflix.moviedetail.repository.MovieDetailRepository

class MovieDetailViewModel : ViewModel() {
    private val repository  = MovieDetailRepository(DirectorLocalDataSource())
    private var _response : MutableLiveData<MovieWithDirectorModel> = MutableLiveData()
    val response : LiveData<MovieWithDirectorModel> = _response

    fun getMovieWithDirector(movie: Movie){
        try {
            _response.value = repository.getMovieWithDirector(movie)
        }catch (e:Exception){
            Log.e("Erro", e.message.toString())
        }

    }
}