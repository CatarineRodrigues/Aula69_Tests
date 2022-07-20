package br.com.zup.movieflix.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.databinding.ActivityLoginBinding
import br.com.zup.movieflix.home.view.HomeActivity
import br.com.zup.movieflix.login.model.LoginModel
import br.com.zup.movieflix.login.viewmodel.LoginViewModel
import br.com.zup.movieflix.register.view.RegisterActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observers()

        viewModel.getSavedData()

        binding.tvRegistro.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.bvLogin.setOnClickListener {
            authenticate()
        }

    }

    private fun authenticate(){
        val user = binding.etUsername.text.toString()
        val password =  binding.etPassword.text.toString()
        val login = LoginModel(user,password)

        viewModel.authentication(login, binding.swSaveData.isChecked)

    }

    private fun observers(){
        viewModel.response.observe(this){
            if(it.accessAuth){
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Usuario ou senha invalidos", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.savedData.observe(this){
            binding.etUsername.setText(it.user)
            binding.etPassword.setText(it.password)
        }
        viewModel.saveDataFlag.observe(this){
            binding.swSaveData.isChecked = it
        }
    }
}