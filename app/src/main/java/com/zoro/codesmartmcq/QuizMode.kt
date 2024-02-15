package com.zoro.codesmartmcq

data class QuizMode(
    val id : String,
    val title : String,
    val subtitle : String,
    val time : String,
){
    constructor() : this("","","","")
}
