package com.example.mysharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        initUI()
        checkUserValues()

    }

     fun checkUserValues() {
         if (prefs.getName().isNotEmpty()){
         goAccess()
         // prefs es el companion object
             //Aqui estamos diciendo que si name no esta vacio nos lleve a la funcion goAccess
         }

    }

     fun goAccess() {
        startActivity(Intent(this, AccesActivity::class.java))
         //esta funcion es un intent
    }

    fun initUI() {
        b.btnAcces.setOnClickListener {
            accessSharedPreferences()
        }
    }

    fun accessSharedPreferences() {
        if  (b.etName.text.toString().isNotEmpty()) {
            prefs.saveName(b.etName.text.toString())
            prefs.saveColor(b.ckbColor.isChecked)
            goAccess ()
        } else {
            Toast.makeText(this, "debe rellenar el nombre", Toast.LENGTH_LONG).show()
        }

    }



}