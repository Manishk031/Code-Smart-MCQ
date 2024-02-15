package com.zoro.codesmartmcq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.zoro.codesmartmcq.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModeList : MutableList<QuizMode>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModeList = mutableListOf()
        getDataFromFirebase()
    }
    private fun setupRecyclerView()
    {
        adapter = QuizListAdapter(quizModeList)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
    }

    private fun getDataFromFirebase()
    {
        // Dummy data store...
        quizModeList.add(QuizMode("1","programming","All the programming","10"))
        quizModeList.add(QuizMode("2","Computer","All the computer programming","20"))
        quizModeList.add(QuizMode("3","Algo","All the algo learn","5"))
        quizModeList.add(QuizMode("4","programming","All the programming","10"))
        quizModeList.add(QuizMode("5","Computer","All the computer programming","20"))
        quizModeList.add(QuizMode("6","Algo","All the algo learn","5"))
        quizModeList.add(QuizMode("7","programming","All the programming","10"))
        quizModeList.add(QuizMode("8","Computer","All the computer programming","20"))
        quizModeList.add(QuizMode("9","Algo","All the algo learn","5"))
        setupRecyclerView()
    }
}