package com.example.calculadora_de_gorjeta

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPrice = findViewById<TextInputEditText>(R.id.edt_price)
        val edtTip = findViewById<TextInputEditText>(R.id.edt_tip)
        val edtPessoas = findViewById<TextInputEditText>(R.id.edt_pessoas)
        val btn_Calcular = findViewById<Button>(R.id.btn_Calcular)

        val resultPrice = findViewById<TextView>(R.id.tv_result)
        val resultNotip = findViewById<TextView>(R.id.tv_resultNotip)
        val resultTip = findViewById<TextView>(R.id.tv_resultTip)

        btn_Calcular.setOnClickListener() {

            val priceStr: String = edtPrice.text.toString()
            val tipStr: String = edtTip.text.toString()
            val pessoasStr: String = edtPessoas.text.toString()

            if (priceStr == "" || tipStr == "" || pessoasStr == "") {

                Snackbar.make(
                    edtPrice,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val price = priceStr.toFloat()
                val tip = tipStr.toFloat()
                val pessoas = pessoasStr.toFloat()

                val priceQ2 = price / pessoas
                val tipQ2 = (price * tip) / (100 * pessoas)
                val result = priceQ2 + tipQ2
                //resultPrice.text = result.toString()
                resultPrice.text = "R$ %.2f".format(result)
                resultNotip.text = priceQ2.toString()
                resultTip.text = tipQ2.toString()


            }
        }


    }
}