package br.com.zup.movieflix.login.model

data class LoginModel (
    var user : String,
    var password : String,
    var accessAuth : Boolean = false
        )