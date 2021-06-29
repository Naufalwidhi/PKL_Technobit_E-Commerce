package com.technobit.e_commerce.Activity.Authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.technobit.e_commerce.Activity.MainActivity
import com.technobit.e_commerce.Api.MyClient
import com.technobit.e_commerce.Model.UserAccount
import com.technobit.e_commerce.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val input_email = findViewById<EditText>(R.id.input_email_login)
        val input_password = findViewById<EditText>(R.id.input_password_login)
        val lupa_password = findViewById<TextView>(R.id.lupa_password_login)

        val img_back = findViewById<ImageView>(R.id.back_button)

        val btnlogin = findViewById<Button>(R.id.login_button_login)
        val btnregister = findViewById<Button>(R.id.signup_button_login)

        val nama = "Naufal"

        img_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            UserAccount(5,nama, input_email.text.toString(), input_password.text.toString())
            login(nama,input_email.text.toString(), input_password.text.toString())
        }
        btnregister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(name: String, email: String, password: String) {
        MyClient.myApiClient().login(name, email, password)
            .enqueue(object : Callback<UserAccount> {
            override fun onFailure(call: Call<UserAccount>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<UserAccount>, response: Response<UserAccount>) {
                if (response.isSuccessful){
                    Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this@LoginActivity, "Email / Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}