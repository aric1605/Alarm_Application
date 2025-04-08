package com.aric.alarm_application

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class AlarmActivity : AppCompatActivity() {

    private var currentQuestion = 0
    private var correctAnswers = 0
    private val questions = mutableListOf<Question>()
    private val totalQuestions = 10

    data class Question(val num1: Int, val num2: Int, val operation: String, val answer: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.setStreamVolume(AudioManager.STREAM_ALARM, audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM), 0)

        generateQuestions()
        displayQuestion()

        findViewById<Button>(R.id.submitButton).setOnClickListener { checkAnswer() }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "Complete the quiz to stop the alarm!", Toast.LENGTH_SHORT).show()
            return true // Consume the back press
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (correctAnswers != totalQuestions) {
            val serviceIntent = Intent(this, AlarmService::class.java)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }
    }


    private fun generateQuestions() {
        for (i in 1..totalQuestions) {
            val num1 = Random.nextInt(1, 101)
            val num2 = Random.nextInt(1, 101)
            val isAddition = Random.nextBoolean()
            val operation = if (isAddition) "+" else "-"
            val answer = if (isAddition) num1 + num2 else num1 - num2
            questions.add(Question(num1, num2, operation, answer))
        }
    }

    private fun displayQuestion() {
        val question = questions[currentQuestion]
        findViewById<TextView>(R.id.questionText).text = "${question.num1} ${question.operation} ${question.num2} = ?"
        findViewById<TextView>(R.id.progressText).text = "Question ${currentQuestion + 1} of $totalQuestions"
        findViewById<EditText>(R.id.answerInput).text.clear()
    }

    private fun checkAnswer() {
        val userAnswer = findViewById<EditText>(R.id.answerInput).text.toString().toIntOrNull()
        if (userAnswer == null) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            return
        }

        if (userAnswer == questions[currentQuestion].answer) {
            correctAnswers++
        }

        currentQuestion++
        if (currentQuestion < totalQuestions) {
            displayQuestion()
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        if (correctAnswers == totalQuestions) {
            stopService(Intent(this, AlarmService::class.java))
            Toast.makeText(this, "Alarm stopped! All answers correct!", Toast.LENGTH_LONG).show()
            finish()
        } else {
            Toast.makeText(this, "You got $correctAnswers/$totalQuestions. Try again!", Toast.LENGTH_LONG).show()
            currentQuestion = 0
            correctAnswers = 0
            questions.clear()
            generateQuestions()
            displayQuestion()
        }
    }
}
