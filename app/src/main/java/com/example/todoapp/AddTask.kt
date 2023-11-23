package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class AddTask : AppCompatActivity() {

    private lateinit var taskList: ArrayList<TaskData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        taskList = intent.getSerializableExtra("taskDataList") as? ArrayList<TaskData>
            ?: ArrayList()

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val radioGroupPriority = findViewById<RadioGroup>(R.id.radioGroupPriority)
        val etEndDate = findViewById<EditText>(R.id.etEndDate)
        val btnAddDetails = findViewById<Button>(R.id.btnAddDetails)

        btnAddDetails.setOnClickListener {
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()
            val priority = when (radioGroupPriority.checkedRadioButtonId) {
                R.id.radioHigh -> Priority.HIGH
                R.id.radioMedium -> Priority.MEDIUM
                R.id.radioLow -> Priority.LOW
                else -> Priority.MEDIUM
            }
            val endDate = etEndDate.text.toString()

            val task = TaskData(title, description, priority, endDate)

            taskList.add(task)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("taskDataList", taskList as Serializable)
            startActivity(intent)
        }
    }
}
