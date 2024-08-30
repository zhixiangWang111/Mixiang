package com.example.mixiang

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class TiaoxiangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiaoxiang)

        val spinnerCategory1: Spinner = findViewById(R.id.spinnerCategory1)
        val spinnerCategory2: Spinner = findViewById(R.id.spinnerCategory2)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)

        // 创建适配器并设置第一个下拉菜单的数据
        val category1Adapter = ArrayAdapter.createFromResource(
            this,
            R.array.category1_array,
            android.R.layout.simple_spinner_item
        )
        category1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory1.adapter = category1Adapter

        // 创建适配器并设置第二个下拉菜单的数据
        val category2Adapter = ArrayAdapter.createFromResource(
            this,
            R.array.category2_array,
            android.R.layout.simple_spinner_item
        )
        category2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory2.adapter = category2Adapter

        // 设置按钮点击事件
        btnConfirm.setOnClickListener {
            // 获取选择的香料信息
            val selectedCategory1 = spinnerCategory1.selectedItemPosition
            val selectedCategory2 = spinnerCategory2.selectedItemPosition

            // 判断第一个下拉菜单的类别
            val category1Result = when {
                selectedCategory1 < 29 -> "属柑橘类香调——明亮、清新，带有柑橘的酸甜香气，充满活力和清新感。属于柑橘类香调"
                selectedCategory1 < 115 -> "属花香类香调——柔和、芳香，散发着明显的花香气息，营造浪漫、女性化的氛围。"
                selectedCategory1 < 192-> "属绿色，本草和森林类香调——清新、绿意盎然，融合森林的气息，营造清幽的自然感觉"
                selectedCategory1 < 249 ->"属木质和苔藓类香调——温馨、木质，具有木质香的特性，伴随苔藓和淡淡的花香"
                selectedCategory1 < 275 ->"属麝香，龙涎香，动物类气味香调——温暖、性感，具有麝香与动物的特殊香气，伴随花香、木质和香草元素"

                else -> "错误"
            }

            // 判断第二个下拉菜单的类别
            val category2Result = when {
                selectedCategory2 < 86 -> "并伴有淡淡的甜蜜、多汁，融合的香味，营造充满生机和自然的感觉，适合日常或休闲场合"
                selectedCategory2 < 109 -> "并伴有优雅、芬芳，清新而丰富，带有淡淡的香草和奶油味，适合温馨的场合"
                selectedCategory2 < 140 ->"并伴有辛辣、温暖，具有香料的特质，伴随木质和花香元素，散发层次感，适合冷季或夜晚场合"
                selectedCategory2 < 174 ->"并伴有甜美、诱人，散发糖果美食的香气，令人联想到甜点和糖果，适合甜蜜的场合或冬季"
                selectedCategory2 < 200 ->"并伴有深沉、神秘，具有树脂味，搭配香脂元素，散发古老而神秘的气息，适合正式或晚间场合"
                selectedCategory2 < 243 ->"并伴有清新、浓郁，具有的水果和香料的香气，适合白天或社交场合"

                else -> "错误"
            }

            // 拼接结果文本
            val resultText = "$category1Result$category2Result"

            // 启动结果 Activity，并传递结果文本
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", resultText)
            startActivity(intent)
        }

    }
}
