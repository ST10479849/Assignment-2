package za.ac.iie.quizit

import android.content.Intent
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

        // intialising my counters
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
                score++
                txtFeedback.text = "Correct"
            } else { txtFeedback.text = "Incorrect"}
            btnTrue.isEnabled = true
            btnNext.isEnabled = true
            btnFalse.isEnabled = false
        }

        btnTrue.setOnClickListener{
            checkAnswer(true)
        }
       btnFalse.setOnClickListener{
           checkAnswer(false)
       }
        // the next button takes the user to the next screen

        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < quiz.size) {
                txtQuestion.text = quiz[currentQuestionIndex]
                txtFeedback.text = ""
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
                btnNext.isEnabled = false
            } else { val intent = Intent(this, ScoreActivity ::class.java)
                intent.putExtra("Score",score)
                intent.putExtra("Quiz",quiz)
                intent.putExtra("Answers",answers)
                startActivity(intent)
                finish()
            }
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}