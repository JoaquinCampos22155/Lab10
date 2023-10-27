package com.example.firebasetutoriallab10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundel()
        bundle.putString("message", "Integración de Firebase completa",)
        analytics.logEvent("InitScreen", bundle)

        //setup
        setup()
    }
    private fun setup(){
        title = "Autenticación"
        signupButton.setOnClickListener{
            if emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailEditText.text.toString()
                    , passwordEditText.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                }

            }
        }
        logInButton.setOnClickListener{
            if emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString()
                , passwordEditText.text.toString()).addOnCompleteListener{
                if (it.isSuccessful){
                    showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                }else{
                    showAlert()
                }
            }

        }
        }

    }
    private fun showAlert(){
        val builder = AlertDialog.Buillder(this)
        builder.setTitle("error")
        builder.setMessage("Se ha proucido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()

    }
    private fun showHome(email:String, privider:ProviderType)
        val homeIntent ? Intent(this, HomeActivity::class.java).apply{
            putExtra("email", email)
            putExtra("provider", provider.name)
    }
    startActivity(homeIntent)
}