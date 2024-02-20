package com.zoro.codesmartmcq

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.zoro.codesmartmcq.databinding.ActivityMcqactivityBinding
import com.zoro.codesmartmcq.databinding.ScoreDialogBinding

class MCQActivity : AppCompatActivity(), View.OnClickListener{

    companion object{

        var QuestionModel : List<QuestionModel> = listOf()
        var time : String = ""
    }

    lateinit var binding: ActivityMcqactivityBinding
    var currentQuestionIndex =0;
    var selectedAnswer =""
    var score = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMcqactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn0.setOnClickListener(this@MCQActivity)
            btn1.setOnClickListener(this@MCQActivity)
            btn2.setOnClickListener(this@MCQActivity)
            btn3.setOnClickListener(this@MCQActivity)
            nextBtn.setOnClickListener(this@MCQActivity)
        }
        loadQuestion()
        startTimer()
    }

    private fun startTimer() {
        val totalTimerInMillis = time.toInt() * 60 * 1000L
        object : CountDownTimer(totalTimerInMillis,1000L) {
            override fun onTick(millisUntilfinished: Long) {
              val seconds = millisUntilfinished/1000
                val minutes = seconds/60
                val remainingSecond = seconds % 60
                binding.timerIndicator.text = String.format("%02d:%02d",minutes,remainingSecond)
            }

            override fun onFinish() {
            //finish the quiz
            }


        }.start()
    }

    private fun loadQuestion()
    {
        selectedAnswer =""
        if(currentQuestionIndex==QuestionModel.size){
            finishQuiz()
            return
        }

   binding.apply {
       questionTextview.text= "Question ${currentQuestionIndex+1} / ${QuestionModel.size}"
     quizProgressIndicator.progress =
         (currentQuestionIndex.toFloat() / QuestionModel.size.toFloat()*100).toInt()
       questionTextview.text = QuestionModel[currentQuestionIndex].question
       btn0.text = QuestionModel[currentQuestionIndex].options[0]
       btn1.text = QuestionModel[currentQuestionIndex].options[1]
       btn2.text = QuestionModel[currentQuestionIndex].options[2]
       btn3.text = QuestionModel[currentQuestionIndex].options[3]

   }
    }

    override fun onClick(view : View?) {

        binding.apply {
            btn0.setBackgroundColor(getColor(R.color.grey))
            btn1.setBackgroundColor(getColor(R.color.grey))
            btn2.setBackgroundColor(getColor(R.color.grey))
            btn3.setBackgroundColor(getColor(R.color.grey))
        }
        //click a btn for next
        val clickedBtn = view as Button


        if(clickedBtn.id==R.id.next_btn)
        {
            if(selectedAnswer.isEmpty()){
                Toast.makeText(applicationContext,"Please select answer to continue",Toast.LENGTH_SHORT).show()
                return;
            }
            // next button is clicked
            if(selectedAnswer== QuestionModel[currentQuestionIndex].correct)    {
                score++
                Log.i("Score of quiz",score.toString())
            }
            currentQuestionIndex++
            loadQuestion()
        }else{
            // option button  is clicked
            selectedAnswer = clickedBtn.text.toString()
            clickedBtn.setBackgroundColor(getColor(R.color.green))

        }
    }
    private fun finishQuiz()
    {
        val totalQuestions = QuestionModel.size
        val percentage = ((score.toFloat() / totalQuestions.toFloat())*100).toInt()

        val dialogBinding = ScoreDialogBinding.inflate(layoutInflater)
        dialogBinding.apply {
            scoreProgress.progress = percentage
            scoreText.text = "$percentage%"
            if(percentage>60) {
                scoreTitle.text = "Congrats! You have passed"
                scoreTitle.setTextColor(Color.BLUE)
            }else{
                scoreTitle.text = "Oops! You have failed"
                scoreTitle.setTextColor(Color.RED)
            }
            scoreSubtitle.text = "$score out of $totalQuestions are correct"
            finishBtn.setOnClickListener{
                finish()
            }

        }

        AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .show()

    }
}