package com.zoro.codesmartmcq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import com.zoro.codesmartmcq.databinding.ActivityMcqactivityBinding

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
            btn0.setBackgroundColor(getColor(R.color.lightpurple))
            btn1.setBackgroundColor(getColor(R.color.lightpurple))
            btn2.setBackgroundColor(getColor(R.color.lightpurple))
            btn3.setBackgroundColor(getColor(R.color.lightpurple))
        }
        val clickedBtn = view as Button
        if(clickedBtn.id==R.id.next_btn)
        {
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

    }
}