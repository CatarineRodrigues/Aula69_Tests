package br.com.zup.movieflix.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.home.repository.HomeRepository
import java.lang.Exception

class HomeViewModel : ViewModel() {
    private val repository = HomeRepository()
    private val _response: MutableLiveData<List<Movie>> = MutableLiveData()
    val response: LiveData<List<Movie>> = _response

    fun getAllMovies(){
        try {
            _response.value = repository.getListMovie()
        }catch (ex: Exception){
            Log.i("Error", "------> ${ex.message}")
        }
    }
}