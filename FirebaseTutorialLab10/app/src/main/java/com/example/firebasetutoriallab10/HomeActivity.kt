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
    }
}