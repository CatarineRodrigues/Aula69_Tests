package br.com.zup.movieflix.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.movieflix.databinding.MovieItemBinding
import br.com.zup.movieflix.home.model.Movie

class HomeAdapter(private var movieList: MutableList<Movie>,
                  private  val clickMovie : (movie : Movie) -> Unit):
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.showMovieInfo(movie)
        holder.binding.cvItemLista.setOnClickListener {
            clickMovie(movie)
        }
        holder.showMovieInfo(movie)
    }

    override fun getItemCount() = movieList.size

        fun atualizarListaFilme(novaLista:List<Movie>){
            if (movieList.size == 0){
                movieList = novaLista as MutableList<Movie>
            }else{
                movieList.addAll(novaLista)
            }
            notifyDataSetChanged()
        }



    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun showMovieInfo(movie: Movie){
            binding.tvMovieName.text = movie.title
            binding.ivMoviePoster.setImageResource(movie.image)
        }
    }
}