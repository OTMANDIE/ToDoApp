package com.example.todoapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val i = intent
        val taskList = i.getSerializableExtra("taskDataList") as? ArrayList<TaskData>
        val addButton: ImageButton = findViewById(R.id.addButton)
        if (taskList != null) {
            taskAdapter = TaskAdapter(taskList)
            recyclerView.adapter = taskAdapter
        } else {
            taskAdapter = TaskAdapter(getSampleTaskData())
            recyclerView.adapter = taskAdapter
        }
        addButton.setOnClickListener {
            val intent = Intent(this, AddTask::class.java)
            intent.putExtra("taskDataList", ArrayList(taskAdapter.getTaskList()))
            startActivity(intent)
        }
    }
    private fun getSampleTaskData(): MutableList<TaskData> {
        val dataList = mutableListOf<TaskData>()
        dataList.add(TaskData("Task 1", "Description 1", Priority.HIGH, "2023-11-24"))
        dataList.add(TaskData("Task 2", "Description 2", Priority.MEDIUM, "2023-11-25"))
        return dataList
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {true}
            R.id.menu_help -> {true}
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_settings -> {
                    true
                }
                R.id.menu_help -> {
                    true
                }
                else -> false
            }
        }
    }
}

