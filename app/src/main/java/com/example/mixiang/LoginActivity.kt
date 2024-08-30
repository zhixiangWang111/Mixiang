package com.example.mixiang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        usernameEditText = findViewById(R.id.editText1)
        passwordEditText = findViewById(R.id.editText2)
        loginButton = findViewById(R.id.button1)
        registerButton = findViewById(R.id.registerButton) // Assuming you have a registration button in your layout

        loginButton.setOnClickListener {
            // 处理登录按钮的点击事件
            val savedUsername = SharedPreferencesUtil.getUsername(this)
            val savedPassword = SharedPreferencesUtil.getPassword(this)

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == savedUsername && password == savedPassword) {
                // 登陆成功，跳转到MainActivity
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            } else {
                // 登陆失败，显示AlertDialog
                showAlertDialog("登录失败", "用户名或密码输入错误")
            }
        }

        registerButton.setOnClickListener {
            // 处理注册按钮的点击事件
            // You should replace the following lines with your actual registration logic
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showAlertDialog(title: String, message: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("确定", null)
            .show()
    }
}


