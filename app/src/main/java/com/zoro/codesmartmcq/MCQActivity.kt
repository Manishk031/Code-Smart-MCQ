package com.zoro.codesmartmcq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zoro.codesmartmcq.databinding.ActivityMcqactivityBinding

class MCQActivity : AppCompatActivity() {

    companion object{

        var QuestionModel : List<QuestionModel> = listOf()
    }

    lateinit var binding: ActivityMcqactivityBinding
    val currentQuestionIndex =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMcqactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadQuestion()
    }

    private fun loadQuestion()
    {
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
}