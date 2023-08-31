package com.example.quizz

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.quizz.Result

class questionPage : AppCompatActivity(), View.OnClickListener {

    private var questionList:ArrayList<questions>? = null
    private var cur:Int = 1
    private var curPos:Int = -1

    private var head: TextView? = null
    private var img:ImageView? = null
    private var progressBar:ProgressBar? = null
    private var progressText:TextView? = null
    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null
    private var sumbit:AppCompatButton? = null
    private var ques: questions? = null
    private var correctAnswer:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)

        questionList = Details.getQuestions()

        head = findViewById(R.id.questionHeading)
        img  = findViewById(R.id.img)
        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        sumbit = findViewById(R.id.sumbit)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        sumbit?.setOnClickListener(this)





        setQuestion()
    }


    private fun defaultOption(){
        val options = ArrayList<TextView>();
        option1?.let {
            options.add(it)
        }
        option2?.let {
            options.add(it)
        }
        option3?.let {
            options.add(it)
        }
        option4?.let {
            options.add(it)
        }

        for(opt in options){
            opt.setBackgroundResource(R.drawable.textviewbox)
            opt.typeface = Typeface.DEFAULT
        }

    }

    private fun setQuestion() {
        defaultOption()
        Log.i("This is the list of questions", "$questionList")

        ques = questionList!![cur - 1];

        head?.text = ques!!.question
        img?.setImageResource(ques!!.image)
        progressBar?.progress = cur as Int
        progressText?.text = "${cur}/${progressBar?.max}"
        option1?.text = ques!!.optionOne
        option2?.text = ques!!.optionTwo
        option3?.text = ques!!.optionThree
        option4?.text = ques!!.optionfour
    }

    private fun SelectedOptionView(v:TextView, SelectedOption:Int){

        defaultOption()
        curPos = SelectedOption
        v.setTypeface(v.typeface, Typeface.BOLD)
        v.setBackgroundResource(R.drawable.selectedbox)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1 -> option1?.let { SelectedOptionView(it, 1) }
            R.id.option2 -> option2?.let { SelectedOptionView(it, 2) }
            R.id.option3 -> option3?.let { SelectedOptionView(it, 3) }
            R.id.option4 -> option4?.let { SelectedOptionView(it, 4) }

            R.id.sumbit -> sumbit?.let {
                if(curPos == -2){
                    setQuestion()
                }
                else{
                    if(cur == questionList!!.size ){
                        check()
                        it.text = "FINISH"
                        val intent = Intent(this, Result::class.java)
                        intent.putExtra( "correct", correctAnswer.toString())
                        startActivity(intent)
                    }
                    else{
                        check()
                        cur++;
                        curPos = -2
                    }

                }

            }
        }

    }

    private fun check() {
        if(curPos == ques!!.CorrectOption){
            correctAnswer++
            changeBoxColorGreen()
        }
        else{
            changeBoxColorRed()
//            changeBoxColorGreen()

        }

    }

    private fun changeBoxColorGreen() {
        when(curPos){
            1 -> option1!!.setBackgroundResource(R.drawable.correctselection)
            2 -> option2!!.setBackgroundResource(R.drawable.correctselection)
            3 -> option3!!.setBackgroundResource(R.drawable.correctselection)
            4 -> option4!!.setBackgroundResource(R.drawable.correctselection)
        }

    }

    private fun changeBoxColorRed() {
        when(curPos){
            1 -> option1!!.setBackgroundResource(R.drawable.wrongselection)
            2 -> option2!!.setBackgroundResource(R.drawable.wrongselection)
            3 -> option3!!.setBackgroundResource(R.drawable.wrongselection)
            4 -> option4!!.setBackgroundResource(R.drawable.wrongselection)
        }

    }
}