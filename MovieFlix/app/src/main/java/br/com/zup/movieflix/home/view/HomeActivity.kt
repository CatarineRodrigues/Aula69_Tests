package br.com.zup.movieflix.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.movieflix.CHAVE_MOVIE
import br.com.zup.movieflix.databinding.ActivityHomeBinding
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.home.view.adapter.HomeAdapter
import br.com.zup.movieflix.home.viewmodel.HomeViewModel
import br.com.zup.movieflix.moviedetail.view.MovieDetailActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val adapter: HomeAdapter by lazy {
        HomeAdapter(arrayListOf(), this::goToMovieDetail)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getAllMovies()
        observables()
        setUpRvMovieList()
    }

    private fun observables(){
        viewModel.response.observe(this) {
            adapter.atualizarListaFilme(it)
        }
    }

    private fun setUpRvMovieList(){
        binding.rvMovieList.adapter = adapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(this)
    }


    private fun goToMovieDetail(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java).apply {
            putExtra(CHAVE_MOVIE,movie)
        }
        startActivity(intent)
    }

}