package com.example.tp3dominguezjuan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*



class Gustos : AppCompatActivity() {

    lateinit var btnCaja1: Button
    lateinit var btnCaja2: Button
    lateinit var btnCaja3: Button
    lateinit var cb1: CheckBox
    lateinit var cb2: CheckBox
    lateinit var cb3: CheckBox
    lateinit var cb4: CheckBox
    lateinit var activity_pedidos: LinearLayout
    lateinit var bMostrar:Button
    lateinit var bHome:Button
    lateinit var tvTipoHelado: TextView
    var contadorPedidoCaja1:Int=0
    var contadorPedidoCaja2:Int=0
    var contadorPedidoCaja3:Int=0
    val lista:ArrayList<String> = ArrayList<String>()
    val pedido:ArrayList<String> = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gustos)

        btnCaja1= findViewById(R.id.btncaja1)
        btnCaja2=findViewById(R.id.btncaja2)
        btnCaja3=findViewById(R.id.btncaja3)
        cb1=findViewById(R.id.cbDulce)
        cb2=findViewById(R.id.cbChoco)
        cb3=findViewById(R.id.cbTramontana)
        cb4=findViewById(R.id.cbNaranja)
        activity_pedidos=findViewById(R.id.muestroPeididoLayout)
        bMostrar=findViewById(R.id.btnMostrar)
        bHome=findViewById(R.id.btnHome)


        val tipoHelado:String = intent.getStringExtra("TipoHelado").toString()
        tvTipoHelado=findViewById(R.id.tipoHeladotv)
        tvTipoHelado.setText(tipoHelado)

        cb1.setOnCheckedChangeListener { buttonView, isChecked ->
            pedido.add("Dulce de leche ");
        }

        cb2.setOnCheckedChangeListener { buttonView, isChecked ->
            pedido.add("Chocolate ");
        }

        cb3.setOnCheckedChangeListener { buttonView, isChecked ->
            pedido.add("Tramontana ");
        }

        cb4.setOnCheckedChangeListener { buttonView, isChecked ->
            pedido.add("Naranja");
        }


        btnCaja1.setOnClickListener(View.OnClickListener {
            if(contadorPedidoCaja1 <15 ){
                lista.add("caja1 - " + tvTipoHelado.text.toString() + pedido)
                Toast.makeText(this,"pedido agregado caja 1 ", Toast.LENGTH_SHORT).show()
                contadorPedidoCaja1++
                cb1.isChecked=false
                cb2.isChecked=false
                cb3.isChecked=false
                cb4.isChecked=false
                pedido.clear()

            }else{
                Toast.makeText(this,"Caja Cerrada", Toast.LENGTH_SHORT).show()
                btnCaja1.isEnabled=false
            }
        })
        btnCaja2.setOnClickListener(View.OnClickListener {
            if(contadorPedidoCaja2<5 ){
                lista.add("caja2 - " + tvTipoHelado.text.toString()+pedido)
                Toast.makeText(this,"pedido agregado caja 2 ", Toast.LENGTH_SHORT).show()
                contadorPedidoCaja2++
                cb1.isChecked=false
                cb2.isChecked=false
                cb3.isChecked=false
                cb4.isChecked=false
                pedido.clear()

            }else{
                Toast.makeText(this,"Caja Cerrada", Toast.LENGTH_SHORT).show()
                btnCaja2.isEnabled=false
            }
        })
        btnCaja3.setOnClickListener(View.OnClickListener {
            if(contadorPedidoCaja3<10 ){
                lista.add("caja3 - " + tvTipoHelado.text.toString()+pedido)
                Toast.makeText(this,"pedido agregado caja 3 ", Toast.LENGTH_SHORT).show()
                contadorPedidoCaja3++
                pedido.clear()
                cb1.isChecked=false
                cb2.isChecked=false
                cb3.isChecked=false
                cb4.isChecked=false
                pedido.clear()

            }else {
                Toast.makeText(this, "Caja Cerrada", Toast.LENGTH_SHORT).show()
                btnCaja3.isEnabled = false
            }
        })
        bMostrar.setOnClickListener(View.OnClickListener {
            var view = LayoutInflater.from(this).inflate(R.layout.activity_pedidos,null)

            val muestroPedidosText: TextView =  view.findViewById(R.id.pedidos)
            lista.forEach{
                if(it.toString().contains("caja"))
                    muestroPedidosText.text = muestroPedidosText.text.toString() + it + "\n"
            }
            activity_pedidos.removeAllViews()
            activity_pedidos.addView(view)

        })
        bHome.setOnClickListener(View.OnClickListener {


            val i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        })
    }
}