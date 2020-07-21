package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    companion object {
        const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_result.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {
            val input1 = edt_input1.text.toString().trim()
            val input2 = edt_input2.text.toString().trim()

            val inputA = toInt(input1)
            val inputB = toInt(input2)

            when {
                TextUtils.isEmpty(input1) -> {
                    edt_input1.error = "This field is required!"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(input2) -> {
                    edt_input2.error = "This field is required!"
                    return@setOnClickListener
                }
                inputA == null -> {
                    edt_input1.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                inputB == null -> {
                    edt_input2.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                else -> {
                    val result = inputA + inputB
                    tv_result.text = result.toString()
                }
            }
        }
        btn_minus.setOnClickListener {
            val input1 = edt_input1.text.toString().trim()
            val input2 = edt_input2.text.toString().trim()

            val inputA = toInt(input1)
            val inputB = toInt(input2)

            when {
                TextUtils.isEmpty(input1) -> {
                    edt_input1.error = "This field is required!"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(input2) -> {
                    edt_input2.error = "This field is required!"
                    return@setOnClickListener
                }
                inputA == null -> {
                    edt_input1.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                inputB == null -> {
                    edt_input2.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                else -> {
                    val result = inputA - inputB
                    tv_result.text = result.toString()
                }
            }
        }
        btn_times.setOnClickListener {
            val input1 = edt_input1.text.toString().trim()
            val input2 = edt_input2.text.toString().trim()

            val inputA = toInt(input1)
            val inputB = toInt(input2)

            when {
                TextUtils.isEmpty(input1) -> {
                    edt_input1.error = "This field is required!"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(input2) -> {
                    edt_input2.error = "This field is required!"
                    return@setOnClickListener
                }
                inputA == null -> {
                    edt_input1.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                inputB == null -> {
                    edt_input2.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                else -> {
                    val result = inputA * inputB
                    tv_result.text = result.toString()
                }
            }
        }
        btn_devided.setOnClickListener {
            val input1 = edt_input1.text.toString().trim()
            val input2 = edt_input2.text.toString().trim()

            val inputA = toInt(input1)
            val inputB = toInt(input2)

            when {
                TextUtils.isEmpty(input1) -> {
                    edt_input1.error = "This field is required!"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(input2) -> {
                    edt_input2.error = "This field is required!"
                    return@setOnClickListener
                }
                inputA == null -> {
                    edt_input1.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                inputB == null -> {
                    edt_input2.error = "This field is Integer number only!"
                    return@setOnClickListener
                }
                else -> {
                    val result = inputA.toDouble() / inputB.toDouble()
                    tv_result.text = result.toString()
                }
            }
        }
    }

    private fun toInt(string: String): Int? =
        try {
            string.toInt()
        } catch (e: NumberFormatException) {
            null
        }
}