package com.example.guangchengfan.myview.mediacodec

import android.media.MediaCodecInfo
import android.media.MediaCodecList
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.guangchengfan.myview.R


class MediaCodecAct : AppCompatActivity() {


    private var tvMediaCodecOutput: TextView? = null
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mediacodec)
        tvMediaCodecOutput = findViewById(R.id.tv_media_codec_output)

        findViewById<Button>(R.id.btn_mediacodec_list).setOnClickListener {
            tvMediaCodecOutput?.text = ""

            val codecList = MediaCodecList(MediaCodecList.ALL_CODECS)

            val sbInfo = StringBuilder()
            for (i in 0 until codecList.codecInfos.size) {
                sbInfo.append(getCodecInfo(codecList.codecInfos[i]))
            }

            tvMediaCodecOutput?.text = sbInfo
        }

        findViewById<Button>(R.id.btn_CodecCapabilities).setOnClickListener {

        }

   }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun getCodecInfo(mediaCodecInfo: MediaCodecInfo) : String {
        val codecSb = StringBuilder()
        codecSb.append(mediaCodecInfo.name) // 编解码器名称
            .append(" ")
            .append(mediaCodecInfo.canonicalName) // 编解码器规范名称
            .append(" ")
            .append(mediaCodecInfo.isEncoder)// 是编码器吗？
            .append(" ")
            .append(mediaCodecInfo.isVendor) // 是厂商提供的吗？
            .append(" ")
            .append(mediaCodecInfo.isSoftwareOnly)// 纯软件实现的编解码器？
            .append(" ")
            .append(mediaCodecInfo.isHardwareAccelerated)// 有硬件加速？
            .append(" ")
            .append(mediaCodecInfo.supportedTypes)// 支持的媒体类型
            .append("\n")

        mediaCodecInfo.getCapabilitiesForType(mediaCodecInfo.supportedTypes[0])

        return codecSb.toString()
    }
}