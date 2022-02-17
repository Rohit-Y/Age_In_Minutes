package com.example.ageinminute

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.Button1)
        button.setOnClickListener {view->
            Datepicker(view)

        }
    }

        fun Datepicker(view: View){
            var calander=Calendar.getInstance()
            var year=calander.get(Calendar.YEAR)
            var month=calander.get(Calendar.MONTH)
            var day=calander.get(Calendar.DAY_OF_MONTH)
       DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayOfMonth ->
           Toast.makeText(this, "The Chosen Year is $selectedyear,the month is ${selectedmonth+1},the day is $selecteddayOfMonth ", Toast.LENGTH_LONG).show()
           var selcteddate="$selecteddayOfMonth/${selectedmonth+1}/${selectedyear}"
           var textview=findViewById<TextView>(R.id.Seleted_Date)
           textview.setText(selcteddate)
            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
           val theDate=sdf.parse("${selcteddate}")
           var selectedDateInMinutes=theDate!!.time/60000
                      val currentdate=sdf.parse(sdf.format(System.currentTimeMillis()))
                      val currentdateinMinutes=currentdate!!.time/60000
           val ageinminutes= currentdateinMinutes - selectedDateInMinutes
           val ageinhour=ageinminutes/60
           val sectedtimeinhour=findViewById<TextView>(R.id.textView)
           sectedtimeinhour.setText("You are ${ageinhour.toString()} Hours old")
           val selectedtime=findViewById<TextView>(R.id.date)
           selectedtime.setText("You are ${ageinminutes.toString()} Minutes old")
           val ageinsec=ageinminutes*60
           val selctedtimeinsec=findViewById<TextView>(R.id.text)
           selctedtimeinsec.setText("You are  ${ageinsec.toString()} Seconds old")

                                                                }
           ,year,month,day).show()
        }

}
