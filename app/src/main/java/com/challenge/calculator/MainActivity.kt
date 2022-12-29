package com.challenge.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // remove top bar and set the visibility to full screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        // numeral buttons
        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val buttonDot = findViewById<Button>(R.id.button_dot)

        // operations buttons
        val divide = findViewById<Button>(R.id.button_divide)
        val multiply = findViewById<Button>(R.id.button_multiply)
        val minus = findViewById<Button>(R.id.button_minus)
        val sum = findViewById<Button>(R.id.button_sum)
        val openParenthesis = findViewById<Button>(R.id.button_openParenthesis)
        val closeParenthesis = findViewById<Button>(R.id.button_closeParenthesis)


        val resultTv: TextView = findViewById<TextView>(R.id.result_tv)
        val expressionTv: TextView = findViewById<TextView>(R.id.solution_tv)

        resultTv.text = ""
        expressionTv.text = ""

        fun addCalculusExpression(expression: Int){expressionTv.append(expression.toString())}

        fun addCalculusOperator(operator: Char){
            val lastChar = expressionTv.text.last()
            if( lastChar != '+' &&
                lastChar != '-' &&
                lastChar != '*' &&
                lastChar != '/'
            ){
                expressionTv.append(operator.toString())
            }
        }

        fun getCalculusResult(){
            var result = ExpressionBuilder(expressionTv.text.toString()).build().evaluate()
            resultTv.text = result.toString()
        }

        fun cleanLatest(){expressionTv.text = expressionTv.text.dropLast(1)}

        fun clean(){
            resultTv.text = ""
            expressionTv.text = ""
        }

        // Add listener to number's button
        button0.setOnClickListener {addCalculusExpression(0)}
        button1.setOnClickListener{addCalculusExpression(1)}
        button2.setOnClickListener{addCalculusExpression(2)}
        button3.setOnClickListener {addCalculusExpression(3)}
        button4.setOnClickListener {addCalculusExpression(4)}
        button5.setOnClickListener {addCalculusExpression(5)}
        button6.setOnClickListener {addCalculusExpression(6)}
        button7.setOnClickListener {addCalculusExpression(7)}
        button8.setOnClickListener {addCalculusExpression(8)}
        button9.setOnClickListener {addCalculusExpression(9)}


        // add listener to operators button
        multiply.setOnClickListener {addCalculusOperator('*')}
        divide.setOnClickListener {addCalculusOperator('/')}
        minus.setOnClickListener {addCalculusOperator('-')}
        sum.setOnClickListener {addCalculusOperator('+')}

        // add listener to parenthesis buttons & dot
        openParenthesis.setOnClickListener {expressionTv.append("(")}
        closeParenthesis.setOnClickListener {expressionTv.append(")")}


            buttonDot.setOnClickListener {
                if(expressionTv.text.isNotEmpty()) {
                    if (expressionTv.text.last().isDigit()) {
                       expressionTv.append(".")
                    }
                }
            }

        // delete last @char
        findViewById<Button>(R.id.button_C).setOnClickListener{cleanLatest()}

        // clean all
        findViewById<Button>(R.id.button_reset).setOnClickListener{clean()}

        // perform calculus and display result
        findViewById<Button>(R.id.button_equal).setOnClickListener{getCalculusResult()}

    }

    // keep the system UI to full screen when the activity resumes
    override fun onResume() {
        super.onResume()

        // remove top bar and set the visibility to full screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
    }
}