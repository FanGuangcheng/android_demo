package com.example.guangchengfan.myview.ffmpeg

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.me.kevin.utils.videoedit.VideoEditorManager
import org.me.kevin.video.edit.VideoClip

class VideoFfmpegAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_ffmpeg)

        findViewById<Button>(R.id.btn_clip_video).setOnClickListener {

            GlobalScope.launch {

                val videoList = ArrayList<VideoClip>()
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1722995979106.mp4", "1722995979106.mp4", 11000, 5000, 9000, false))
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1723032638188.mp4", "1723032638188.mp4", 13000, 8000, 12000, false))

                VideoEditorManager.clipVideo(videoList)
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

        findViewById<Button>(R.id.btn_edit_videos).setOnClickListener {

            GlobalScope.launch {
                val videoList = ArrayList<VideoClip>()
                // 红米测试机
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1722995979106.mp4", "1722995979106.mp4", 11000, 5000, 9000, false, 1080, 2400))
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1723032638188.mp4", "1723032638188.mp4", 13000, 8000, 12000, false, 1920, 1080))
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/hengping67890.mp4", "hengping67890.mp4", 8000, 0, 4000, false, 1920, 1080))
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/shuping12345.mp4", "shuping12345.mp4", 8000, 4000, 8000, false, 1080, 2400))



                // 华为p30pro测试机
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/153611.mp4", "153611.mp4", 6000, 1000, 4000, false))
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/153666.mp4", "153666.mp4", 10000, 3000, 8000, false))
                VideoEditorManager.editVideos(videoList)
            }
        }

    }
}