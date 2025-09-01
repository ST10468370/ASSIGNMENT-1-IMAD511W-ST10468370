package vcmsa.ci.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextHeading = findViewById<EditText>(R.id.editTextHeading)
        val EditTextinput = findViewById<EditText>(R.id.EditTextinput)
        val buttonEnter = findViewById<Button>(R.id.buttonEnter)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val TextViewoutput = findViewById<TextView>(R.id.TextViewoutput)

        buttonEnter.setOnClickListener {
            val TimeofDay = EditTextinput.text.toString().trim()
            val meal = when (TimeofDay) {
                "Breakfast" -> " Eat a meal consisting of healthy fats, lean proteins, vitamins and carbohydrates, like yoghurt and granola or avocado toast with a beautifully fried egg!"
                "Mid-morning snack" -> "Enjoy a light snack, like an energizing protein bar or smoothie, to keep you going through the day."
                "Lunch" -> " Sit down and appreciate a filling yet light meal, like a chicken cesar-salad or maybe a nutritious sandwich."
                "Afternoon snack" -> " Grab a quick bite, like a fruit bowl or biltong, to keep yourself nourished till dinner time."
                "Dinner" -> "Decompress by relaxing and enjoying a well-rounded meal. Get stuck into a lovely cut of protein of your choice, accompanied by roasted vegetables and carbohydrates, like mash-potatoes, to leave you with a smile."
                "Dessert" -> "Treat yourself to something sweat but not sugar-induced to prevent further cravings. Have a nice serving of ice cream paired with blueberries, or strawberries or any other fruit of your choice."
                else -> "Invalid time of day entered. Please enter a valid time of day and make use of a capital letter at the beginning.The correct prompts are; Breakfast, Mid-morning snack, Lunch, Afternoon snack, Dinner and Dessert."
            }
            TextViewoutput.text = meal
        }
        buttonReset.setOnClickListener{
            EditTextinput.text.clear()
            TextViewoutput.text = ""
        }


    }
}