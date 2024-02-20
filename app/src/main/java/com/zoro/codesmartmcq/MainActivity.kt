package com.zoro.codesmartmcq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
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
        binding.progressBar.visibility = View.GONE
        adapter = QuizListAdapter(quizModeList)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
    }

    private fun getDataFromFirebase()
    {
        binding.progressBar.visibility = View.VISIBLE
        FirebaseDatabase.getInstance().reference
            .get()
            .addOnSuccessListener {
                dataSnapshot-> if(dataSnapshot.exists()){
                    for(snapshot in dataSnapshot.children){
                        val quizModel = snapshot.getValue(QuizMode::class.java)

                        if(quizModel != null){
                            quizModeList.add(quizModel)
                        }
                    }
            }
                setupRecyclerView()
            }

    }
}