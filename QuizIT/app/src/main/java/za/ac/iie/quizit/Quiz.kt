package za.ac.iie.quizit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz2)

        val quiz = arrayOf(
            "There is a possiblity for males to give birth" ,
            "Living species do not need water",
            "Earth is approximately 71% water",
            "Chewing gun is bad for your health",
            "Jamaica is in Africa",
        )

        val answers = arrayOf(false,false,true,true,false)

        var currentQuestionIndex = 0
        var score = 0

        val txtQuestion = findViewById<TextView>(R.id.txtQuestions)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)

        txtQuestion.text = quiz[currentQuestionIndex]
        fun checkAnswer(userAnswer: Boolean){
            val correctAnswer = answers[currentQuestionIndex]
            if (userAnswer == correctAnswer){
                txtFeedback.text = "Correct"
            } else { txtFeedback.text = "Incorrect"}
            btnTrue.isEnabled = true
            btnNext.isEnabled = true
            btnFalse.isEnabled = false
        }

        btnTrue







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}