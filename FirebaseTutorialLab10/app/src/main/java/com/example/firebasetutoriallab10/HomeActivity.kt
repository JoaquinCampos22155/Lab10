package com.example.firebasetutoriallab10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

enum class ProviderType{
    BASIC,
    GOOGLE
}

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //SETUP
        val bunddel = intent.extras
        val email= bundle?.getString("email")
        val provider = bundle?.getString("provider")

        setup(email ?: "", provider ?: "")
    }
    private fun setup(email:String, provider: String){
        title = "Inicio"

        emailTextView.text = email
        providerTextView.text = provider

        csButton.setOnClickListener{
            FirebaseAuthh.getInstance().signOut()
            onBackPressed()
        }

    }
}