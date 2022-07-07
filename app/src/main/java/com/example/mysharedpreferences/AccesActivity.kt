package com.example.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityAccesBinding


class AccesActivity : AppCompatActivity() {
    private lateinit var b: ActivityAccesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAccesBinding.inflate(layoutInflater)
        setContentView(b.root)

        initUI()
    }

     fun initUI() {
         b.bntClose.setOnClickListener {
             prefs.wipeData() //llamamos a la funcion wipeData de Prefs que era para borrar
             onBackPressed() // esto era para volver atras
         }
         val userName = prefs.getName() //llamamos al username que tenemos guardado en la funcion de prefs USER_NAME
         b.tvName.text = "!HOLA $userName!"
         if (prefs.getColorCheck()) {
             b.cardView.setBackgroundColor(ContextCompat.getColor(this, R.color.layout))
         }

    }


}