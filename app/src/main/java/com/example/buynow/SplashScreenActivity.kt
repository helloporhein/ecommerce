package com.example.buynow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.example.buynow.utils.FirebaseUtils
import com.example.buynow.utils.FirebaseUtils.firebaseAuth
import com.example.buynow.utils.FirebaseUtils.firebaseUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class SplashScreenActivity : AppCompatActivity() {

    //private lateinit var firebaseUser: FirebaseUtils
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val firebaseUser: FirebaseUser? = FirebaseUtils.firebaseAuth.currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)


        Handler().postDelayed({

            checkUser()
                              home()

        }, 1000)


    }

    private fun home(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun checkUser() {

            if(FirebaseUtils.firebaseUser?.isEmailVerified == true){
               val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

            // Initialize Firebase Utils

            if(firebaseUser != null) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity (intent)
                finish()
            }
            if(firebaseUser == null){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

}
//SHA1: A5:1E:56:50:5E:4C:A6:6D:6D:80:DE:F0:9D:25:CA:6C:15:6F:47:FB
//SHA-256: 98:36:03:60:7B:AB:B5:2D:26:DA:BD:A9:1A:32:6C:C5:91:17:FF:A9:52:45:13:38:F4:3A:64:35:DC:93:7A:E9