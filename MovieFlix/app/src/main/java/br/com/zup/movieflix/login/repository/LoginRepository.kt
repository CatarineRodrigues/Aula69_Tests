package br.com.zup.movieflix.login.repository

import br.com.zup.movieflix.login.model.LoginModel

class LoginRepository {
    fun authenticate (login : LoginModel) :LoginModel{

        login.accessAuth = (login.user == "usuario" && login.password == "1234") ||
                (login.user == "" && login.password == "")

        return login
    }
}