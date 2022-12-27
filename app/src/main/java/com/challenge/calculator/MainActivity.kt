package com.challenge.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var button_1 = findViewById<Button>(R.id.button_1)
//        private var button_2 = findViewById<Button>(R.id.button_2)
//        private var button_3 = findViewById<Button>(R.id.button_3)
//        private var button_4 = findViewById<Button>(R.id.button_4)
//        private var button_5 = findViewById<Button>(R.id.button_5)
//        private var button_6 = findViewById<Button>(R.id.button_6)
//        private var button_7 = findViewById<Button>(R.id.button_7)
//        private var button_8 = findViewById<Button>(R.id.button_8)
//        private var button_9 = findViewById<Button>(R.id.button_9)


        val resultTv: TextView = findViewById<TextView>(R.id.result_tv)
        val expressionTv: TextView = findViewById<TextView>(R.id.solution_tv)

        resultTv.text = ""
        expressionTv.text = ""

         fun addCalculusExpression(expression: String){
             println(expression)
            expressionTv.append(expression)
        }

        button_1.setOnClickListener{addCalculusExpression("1")}


    }
}