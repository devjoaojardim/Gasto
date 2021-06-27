package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butaocalcular.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.butaocalcular) {
            calcular()
        }
    }

    private fun calcular() {
        if (validar()) {

            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()

                val valorTotal = (distancia * preco) / autonomia
                textoTotal.text = "R$ ${"%.2f".format(valorTotal)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_val), Toast.LENGTH_SHORT)
                    .show()
            }

        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validar(): Boolean {
        return (editDistancia.text.toString() != ""
                && editPreco.text.toString() != ""
                && editAutonomia.text.toString() != ""
                && editAutonomia.text.toString() != "0")
    }
}


