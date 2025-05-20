package za.ac.iie.quizit

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import za.ac.iie.quizit.R.id.txtAnswerReview

class ReviewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

     val txtAnswerReview = findViewById<LinearLayout>(R.id.txtAnswerReview)
     val quiz = intent.getStringArrayExtra("Quiz")
     val answers = intent.getBooleanArrayExtra("Answers")
        if( quiz != null && answers != null ) {
            for (i in quiz.indices) {
                val answersView = TextView(this)
                answersView.text =
                    "${i + 1}. ${quiz[i]}\nAnswer: ${if (answers[i]) "True" else "False"}"
                answersView.textSize = 16f
                answersView.setPadding(0, 24, 0, 24)
                txtAnswerReview.addView(answersView)
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}