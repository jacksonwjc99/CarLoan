package com.example.carloan

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calcCarLoan(it)
        }

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calcCarInterest(it)
        }
    }

    private fun calcCarLoan(view: View){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toInt()
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toInt()

        val string: String = getString(R.string.loan)
        textViewLoan.text = string + " RM" +(carPrice - downPayment).toString();
    }

    private fun calcCarInterest(view: View){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toInt()
        val carInterest = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toInt()
        val intPeriod = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()

        val string: String = getString(R.string.interest)
        textViewInterest.text = string + " RM" +(carPrice * carInterest * intPeriod).toString();
    }
}
