package com.example.guangchengfan.myview.ffmpeg

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.me.kevin.utils.videoedit.VideoEditorManager

class VideoFfmpegAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_ffmpeg)

        findViewById<Button>(R.id.btn_clip_video).setOnClickListener {

            GlobalScope.launch {

                val videoList = ArrayList<VideoClip>()
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1722995979106.mp4", "1722995979106.mp4", 11000, 5000, 9000, false))
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1723032638188.mp4", "1723032638188.mp4", 13000, 8000, 12000, false))

                VideoEditorManager.clipAndMergeVideo(videoList)
            }

        }

        findViewById<Button>(R.id.btn_concat_video).setOnClickListener {

            GlobalScope.launch {
                VideoEditorManager.concatTest("")
            }
        }

        findViewById<Button>(R.id.btn_scale_video).setOnClickListener {

            GlobalScope.launch {
                VideoEditorManager.scaleVideo()
            }
        }

        findViewById<Button>(R.id.btn_info_video).setOnClickListener {

            GlobalScope.launch {
                VideoEditorManager.printVideoInfo()
            }
        }


    }
}