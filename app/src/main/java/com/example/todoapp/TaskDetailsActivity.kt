import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.R

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {

            val etTitle: EditText = findViewById(R.id.etTitle)
            val etDescription: EditText = findViewById(R.id.etDescription)
            val etEndDate: EditText = findViewById(R.id.etEndDate)

            val title = etTitle.text.toString()
            val description = etDescription.text.toString()
            val endDate = etEndDate.text.toString()


            val resultIntent = Intent()
            resultIntent.putExtra("title", title)
            resultIntent.putExtra("description", description)
            resultIntent.putExtra("endDate", endDate)


            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}

