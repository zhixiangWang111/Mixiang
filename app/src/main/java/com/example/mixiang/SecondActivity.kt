package com.example.mixiang

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // 商城按钮
        val button0 = findViewById<Button>(R.id.button0)
        button0.setOnClickListener {
            // 点击商城按钮跳转到淘宝香水商城
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.hermes.cn/cn/zh/category/%E9%A6%99%E6%B0%B4/?utm_source=Baidu&utm_medium=Search&utm_campaign=V_General&utm_content=v_general_perf_mark&utm_term=%E5%95%86%E5%9C%BA%E7%9A%84%E5%93%81%E7%89%8C%E9%A6%99%E6%B0%B4#|")
            startActivity(intent)
        }

        // 调香按钮
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            // 点击调香按钮跳转到Tiaoxiangactivity
            val intent = Intent(this, TiaoxiangActivity::class.java)
            startActivity(intent)
        }

        // 香水科普按钮
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            // 点击香水科普按钮跳转至Kepuactivity
            val intent = Intent(this, KepuActivity::class.java)
            startActivity(intent)
        }
    }
}