package com.zoro.codesmartmcq

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zoro.codesmartmcq.databinding.QuizItemRecyclerRowBinding

class QuizListAdapter(private  val quizModeList : List<QuizMode>) :
    RecyclerView.Adapter<QuizListAdapter.MyViewHolder>() {
     class MyViewHolder(private val binding: QuizItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
fun bind(model : QuizMode)
{
    // bind all the views
    binding.apply {
        titleQuiz.text = model.title
        subtitleQuiz.text =model.subtitle
        timeText.text = model.time + " min"
        root.setOnClickListener{
            val intent = Intent(root.context,MCQActivity::class.java)
            MCQActivity.QuestionModel = model.questionList
            root.context.startActivity(intent)
        }
    }
}
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
           val binding = QuizItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
          return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
     return quizModeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(quizModeList[position])
    }
}