package com.example.mixiang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 获取传递过来的结果文本
        val resultText = intent.getStringExtra("result")

        // 在结果页面展示结果文本
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        resultTextView.text = resultText
    }
}
