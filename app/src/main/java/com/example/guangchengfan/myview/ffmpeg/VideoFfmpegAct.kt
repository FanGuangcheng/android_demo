package com.example.guangchengfan.myview.ffmpeg

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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

            Toast.makeText(this@VideoFfmpegAct, "开始调整视频时长:", Toast.LENGTH_SHORT).show()
            GlobalScope.launch {

                val videoList = ArrayList<VideoClip>()
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1722995979106.mp4", "1722995979106.mp4", 11000, 5000, 9000, false))
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1723032638188.mp4", "1723032638188.mp4", 13000, 8000, 12000, false))

                // 红米测试机
                // 测试z视介拍的视频
//                videoList.add(VideoClip("1000", "/storage/emulated/0/DCIM/fgcaa.mp4", "fgcaa.mp4", 4700, 0, 4500, false))
                // 测试相机拍的视频
//                videoList.add(VideoClip("1000", "/storage/emulated/0/DCIM/Camera/2024fgcccc.mp4", "2024fgcccc.mp4", 4000, 0, 4000, false))

                // z视介自己拍的视频，缺少音频信息，因此使用 使用 -c copy 命令会导致复制音频失败
                // VideoEditorManager.clipVideo(videoList)
                // 去掉 -c copy 命令
                VideoEditorManager.clipVideoNew(videoList)

            }

        }

        findViewById<Button>(R.id.btn_concat_video).setOnClickListener {

            GlobalScope.launch {
                VideoEditorManager.concatTest("")
            }
        }

        findViewById<Button>(R.id.btn_scale_video).setOnClickListener {

            GlobalScope.launch {
//                VideoEditorManager.scaleVideo()
                val videoList = ArrayList<VideoClip>()
                // 红米测试机
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1722995979106.mp4", "1722995979106.mp4", 11000, 5000, 9000, false, 1080, 2400))
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/1723032638188.mp4", "1723032638188.mp4", 13000, 8000, 12000, false, 1920, 1080))
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/hengping67890.mp4", "hengping67890.mp4", 8000, 0, 8000, false, 1920, 1080))
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/shuping12345.mp4", "shuping12345.mp4", 8000, 0, 8000, false, 1080, 2400))


                // 华为p30pro测试机
//                VideoClip(id='883d8d55-073c-48e5-bf2d-8cbc58d29fba', originalFilePath='/storage/emulated/0/aserbaoCamera/153611.mp4', videoFileName='153611.mp4', originalDurationMs=6402, startAtMs=0, endAtMs=6402, isSelected=false), width=1080, height=1920
//                VideoClip(id='105bc072-f320-4471-9ef2-98108f1a1f07', originalFilePath='/storage/emulated/0/aserbaoCamera/153666.mp4', videoFileName='153666.mp4', originalDurationMs=10773, startAtMs=0, endAtMs=10773, isSelected=false), width=1080, height=1920
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/153611.mp4", "153611.mp4", 6402, 0, 6402, false, 1080, 1920))
                videoList.add(VideoClip("1001", "/storage/emulated/0/aserbaoCamera/153666.mp4", "153666.mp4", 10773, 0, 10773, false, 1080, 1920))
                VideoEditorManager.testScaleVideos(videoList)
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
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/hengping67890.mp4", "hengping67890.mp4", 8000, 0, 8000, false, 1920, 1080))
//                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/shuping12345.mp4", "shuping12345.mp4", 8000, 0, 8000, false, 1080, 2400))


                // 华为p30pro测试机
//                VideoClip(id='883d8d55-073c-48e5-bf2d-8cbc58d29fba', originalFilePath='/storage/emulated/0/aserbaoCamera/153611.mp4', videoFileName='153611.mp4', originalDurationMs=6402, startAtMs=0, endAtMs=6402, isSelected=false), width=1080, height=1920
//                VideoClip(id='105bc072-f320-4471-9ef2-98108f1a1f07', originalFilePath='/storage/emulated/0/aserbaoCamera/153666.mp4', videoFileName='153666.mp4', originalDurationMs=10773, startAtMs=0, endAtMs=10773, isSelected=false), width=1080, height=1920
                videoList.add(VideoClip("1000", "/storage/emulated/0/aserbaoCamera/153611.mp4", "153611.mp4", 6402, 0, 6402, false, 1080, 1920))
                videoList.add(VideoClip("1001", "/storage/emulated/0/aserbaoCamera/153666.mp4", "153666.mp4", 10773, 0, 10773, false, 1080, 1920))

                // z视介自己拍的视频，缺少音频信息，因此使用 使用 -c copy 命令会导致复制音频失败
//                videoList.add(VideoClip("1000", "/storage/emulated/0/DCIM/fgcaa.mp4", "fgcaa.mp4", 4700, 0, 4500, false))
                VideoEditorManager.editVideos(videoList)
            }
        }

    }
}