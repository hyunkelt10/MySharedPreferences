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


             val theColor = getMyColor(prefs.getColor())
             b.cardView.setBackgroundColor(
                 ContextCompat.getColor(this, theColor)
             )
         }

    }

    fun getMyColor(color:String):Int{
        val resourceColor = when(color){
            "Rojo"-> R.color.rojo
            "Verde"-> R.color.verde
            "Amarillo"-> R.color.amarillo
            "Naranja"-> R.color.naranja
            "Azul"-> R.color.azul
            "Violeta"-> R.color.violeta
            else ->  R.color.white
        }
        return resourceColor
    }
}