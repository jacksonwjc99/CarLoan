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

        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset(it)
        }
    }

    private fun calcCarLoan(view: View){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toInt()
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toInt()
        val carInterest = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDouble()
        val intPeriod = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()

        val carLoan = carPrice - downPayment;
        val interest = (carPrice * carInterest) * intPeriod;
        val monthlyRepay = ((carLoan + interest) / intPeriod) / 12;

        val string: String = getString(R.string.loan)
        val string1: String = getString(R.string.interest)
        val string2: String = getString(R.string.monthly_repayment)

        textViewLoan.text = string + " RM" + carLoan;
        textViewInterest.text = string1 + " RM" + interest;
        textViewMonthlyRepayment.text = string2 + " RM" + monthlyRepay;
    }

    private fun reset(view: View){
        findViewById<EditText>(R.id.editTextCarPrice).text = null;
        findViewById<EditText>(R.id.editTextDownPayment).text = null;
        findViewById<EditText>(R.id.editTextInterestRate).text = null;
        findViewById<EditText>(R.id.editTextLoanPeriod).text = null;

        val string: String = getString(R.string.loan)
        val string1: String = getString(R.string.interest)
        val string2: String = getString(R.string.monthly_repayment)

        textViewLoan.text = string;
        textViewInterest.text = string1;
        textViewMonthlyRepayment.text = string2;
    }
}
