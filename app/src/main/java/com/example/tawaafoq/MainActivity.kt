package com.example.tawaafoq

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvDatePicker : TextView
    private lateinit var btnDatePicker: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)









//this opens a new page.
        val تسجيل_جديد : Button = findViewById(R.id.تسجيل_جديد)
        تسجيل_جديد.setOnClickListener{

            val intent = Intent(this, SignInPage::class.java)
            startActivity(intent)    }


//this opens a new page.
        val لدي_حساب : Button = findViewById(R.id.لدي_حساب)
        لدي_حساب.setOnClickListener{

            val intent = Intent(this, LogInPage::class.java)
            startActivity(intent)  }







        tvDatePicker = findViewById(R.id.birthDate)
        btnDatePicker = findViewById(R.id.buttonDate)

        val myCalendar = Calendar.getInstance()

        val datePicker= DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar) }

        btnDatePicker.setOnClickListener { DatePickerDialog(this, datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()   }


    }



    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd-mm-yyyy"
        val sdf = java.text.SimpleDateFormat(myFormat, Locale.UK)
        tvDatePicker.setText(sdf.format(myCalendar.time)) }


}