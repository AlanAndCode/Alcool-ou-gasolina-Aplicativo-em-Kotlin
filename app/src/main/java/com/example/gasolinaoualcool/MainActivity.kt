package com.example.gasolinaoualcool

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gasolinaoualcool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //utilizando metodo biding para evitar FindviewByID
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
//utilizando conceito de funçao para validar os campos da aplicaçao
    private fun ValidarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }

    fun CalcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
//converte valore string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()
        /* faz calculo (PrecoAlcool / precoGasolina)
        *Se resultado >= 0.7 melhor utilizar gaolina
        *Senao melhor utilizar Alcool
         */
        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7) {
            binding.textResultado.text = "Melhor utilizar Gasolina"
        } else {
            binding.textResultado.text = "Melhor utilizar Alcool"
        }
    }

    fun calcularPreco(view: View) {
        //Recuperar valores digitados
        val precoAlcool = binding.editPrecoAlcool.text.toString()
        val precoGasolina = binding.editPrecoGasolina.text.toString()

        val validaCampos = ValidarCampos(precoAlcool, precoGasolina)
        if (validaCampos) {
            CalcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            binding.textResultado.text = "Preencha o valor "
        }



}


}