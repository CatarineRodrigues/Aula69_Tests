package br.com.zup.movieflix.home.repository

import br.com.zup.movieflix.*
import br.com.zup.movieflix.home.model.Movie

class HomeRepository {

    fun getListMovie(): List<Movie> {
        val listMovie = mutableListOf<Movie>()

        listMovie.add(Movie(
            PULP_FICTION,
            PULP_FICTION_SINOPSE,
            R.drawable.pulpfiction,
            TARANTINO
        ))
        listMovie.add(Movie(
            TAXI_DRIVER,
            TAXI_DRIVER_SINOPSE,
            R.drawable.taxidriver,
            MARTIN_SCORSESE
        ))
        listMovie.add(Movie(
            DJANGO,
            DJANGO_SINOPSE,
            R.drawable.jango,
            TARANTINO
        ))
        listMovie.add(Movie(
            GOODFELLAS,
            GOODFELLAS_SINOPSE,
            R.drawable.bonscompanheiros,
            MARTIN_SCORSESE
        ))
        listMovie.add(Movie(
            RESEVOIR_DOGS,
            RESEVOIR_DOGS_SINOPSE,
            R.drawable.reservoirdogs,
            TARANTINO
        ))
        listMovie.add(Movie(
            WOLF_WALLSTREET,
            WOLF_WALLSTREET_SINOPSE,
            R.drawable.wolfwallstreet,
            MARTIN_SCORSESE
        ))

        return listMovie
    }
}