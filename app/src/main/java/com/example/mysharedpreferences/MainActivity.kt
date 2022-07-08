package com.example.mysharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var select = "amarillo"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)

        setContentView(b.root)
        Spiner()
        initUI()
        checkUserValues()


    }

    fun checkUserValues() {
        if (prefs.getName().isNotEmpty()) {
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
        if (b.etName.text.toString().isNotEmpty()){
            prefs.saveName(b.etName.text.toString())
            prefs.saveCheckColor(b.checkBox.isChecked)
            prefs.saveColor(select)
            goAccess()
        } else {
            Toast.makeText(this, "debe rellenar el nombre", Toast.LENGTH_LONG).show()
        }

    }

    fun Spiner (){
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.Colores, android.R.layout.simple_spinner_item
        )

        b.btSpinner.adapter = adaptador
        b.btSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                select = parent?.getItemAtPosition(position).toString()


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                select = "Amarillo"

            }


        }
    }
}