package za.ac.iie.quizit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtMessageToPlayer = findViewById<TextView>(R.id.txtMessageToPlayer)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("Score",0)
        val quiz = intent.getStringArrayExtra("Quiz")
        val answers = intent.getBooleanArrayExtra("Answers")

       // Displays the number of correct answers

        txtScore.text = "You got $score out of 5"


        if ( score >= 3) { txtMessageToPlayer.text = " Excellent work! "}
        else{ txtMessageToPlayer.text = " Keep practising"}


        btnReview.setOnClickListener{
            val intent = Intent( this, ReviewActivity::class.java)
            intent.putExtra("Quiz",quiz)
            intent.putExtra("Answers",answers)
            startActivity(intent)
        }
        btnExit.setOnClickListener{
            finishAffinity()
        }

















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}