package com.examplenextqx.moodchangersounds

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.examplenextqx.moodsoundkotlin.R



class PlayActivity : AppCompatActivity() {

    var mMediaPlayer: MediaPlayer? = null
    private lateinit var progressBar: ProgressBar
    private lateinit var titleTv: TextView
    var stop: ImageView? = null
    var start: LottieAnimationView? = null
    var plant: LottieAnimationView? = null
    var planttree: LottieAnimationView? = null
    var next:ImageView?=null
    var prev:ImageView?=null
    var list: ArrayList<ModelF> = ArrayList<ModelF>()
    var musicname: String? = null
    var musictitle:String?=null
    var position:Int?=null
    companion object {
        var positionValue = 0
        fun sendPostion(pos: Int) {
            positionValue = pos
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_activity)
       // progressBar = findViewById(R.id.progressBar)
        stop = findViewById(R.id.stop)
        prev =findViewById(R.id.prev)
        start = findViewById(R.id.animationView)
        next= findViewById(R.id.next)
        plant =findViewById(R.id.animationPlant)

        titleTv =findViewById(R.id.txtName)


//        position =intent.getIntExtra("pos",0)
        list = intent.getParcelableArrayListExtra("namelist")!!



        musicname = list.get(positionValue).musicType.toString()
        musictitle=list.get(positionValue).name

        titleTv.setText(musictitle!!)


        Log.e("mp3Play", " " + musicname)



        start?.setOnClickListener {
            playSound(musicname!!)
            start!!.visibility = View.INVISIBLE
            stop!!.visibility = View.VISIBLE

        }

        stop?.setOnClickListener {
        stopSound()
            start!!.visibility = View.VISIBLE
            stop!!.visibility = View.INVISIBLE

        }






    }

    fun playSound(musicname: String) {
        if (mMediaPlayer == null) {
            Log.e("tagMs2", " " + positionValue)
            mMediaPlayer = MediaPlayer.create(this, musicname.toInt())
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
        } else
            mMediaPlayer!!.start()
    }

    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true)
            mMediaPlayer?.pause()
    }

    // 3. Stops playback

    fun stopSound() {
        if (mMediaPlayer!=null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    override fun onResume() {
        super.onResume()
        next?.setOnClickListener {
            stopSound()
            if(positionValue<list.size-1){
                positionValue++
                start!!.visibility = View.VISIBLE
                stop!!.visibility = View.INVISIBLE
                musicname = list.get(positionValue).musicType.toString()
                musictitle=list.get(positionValue).name
                titleTv.setText(musictitle!!)
                Log.e("tagMs1", " " + positionValue)
            }else{
                start!!.visibility = View.VISIBLE
                stop!!.visibility = View. INVISIBLE
            }

        }
        prev?.setOnClickListener {
            stopSound()
            if(positionValue<list.size-1&& positionValue!=0){
                positionValue = positionValue-1
                start!!.visibility = View.VISIBLE
                stop!!.visibility = View.INVISIBLE
                musicname = list.get(positionValue).musicType.toString()
                musictitle=list.get(positionValue).name
                titleTv.setText(musictitle!!)
                Log.e("tagMs1", " " + positionValue)
            }else{
                start!!.visibility = View.VISIBLE
                stop!!.visibility = View. INVISIBLE
            }
        }

    }


}

