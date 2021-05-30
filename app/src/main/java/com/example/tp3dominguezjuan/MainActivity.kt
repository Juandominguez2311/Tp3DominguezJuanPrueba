package com.example.tp3dominguezjuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b: Button = findViewById(R.id.btnConfirmar)
        val cono: RadioButton = findViewById(R.id.rb_Cono)
        val vaso: RadioButton = findViewById(R.id.rb_Vaso)
        val kilo: RadioButton = findViewById(R.id.rb_Kilo)
        b.setOnClickListener(View.OnClickListener {


            if(cono.isChecked()){
                val respuesta = "Cono"
                val i: Intent = Intent(this, Gustos::class.java)
                i.putExtra("TipoHelado",respuesta)
                startActivity(i)
            }else if(vaso.isChecked()){
                val respuesta = "Vaso"
                val i: Intent = Intent(this, Gustos::class.java)
                i.putExtra("TipoHelado",respuesta)
                startActivity(i)
            }else{
                val respuesta = "Kilo"
                val i: Intent = Intent(this, Gustos::class.java)
                i.putExtra("TipoHelado",respuesta)
                startActivity(i)
            }

    })
}
}