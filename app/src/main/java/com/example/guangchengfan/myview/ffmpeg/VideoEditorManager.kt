package org.me.kevin.utils.videoedit

import android.util.Log
import com.arthenica.mobileffmpeg.ExecuteCallback
import com.arthenica.mobileffmpeg.FFmpeg
import com.example.guangchengfan.myview.MyApplication
import com.example.guangchengfan.myview.ffmpeg.VideoClip
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

object VideoEditorManager: ExecuteCallback {
    private const val CLIP_VIDEO_DIR: String = "zsj_clip_video_folder"
    // 视频裁剪占总操作的比重，即全部完成视频裁剪，占总进度的40%
    private const val CLIP_WEIGHT = 0.4f

    private val clipVideoMap = HashMap<Long, String>()
    private val clipedVideoMap = HashMap<Long, String>()

    fun concatTest(command: String) {
        Log.d("edit_video_log","VideoEditorManager concatTest")

        GlobalScope.launch {


//            /*************************************start  先转成ts再合并，但是视频的分辨率依然被缩放了**********************************************/
//            val outputts1 = getVideoClipSaveParent() + "temp_ts_clip_1722995979106.ts"
//            val resultts1 = FFmpeg.execute("-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1clip_1722995979106.mp4 -c:v copy $outputts1")
//            Log.d("edit_video_log","VideoEditorManager  resultts1 :$resultts1")
//
//            val outputts2 = getVideoClipSaveParent() + "temp_ts_clip_1723032638188.ts"
//            val resultts2 = FFmpeg.execute("-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1clip_1723032638188.mp4 -c:v copy $outputts2")
//            Log.d("edit_video_log","VideoEditorManager  resultts2 :$resultts2")
//
//
//            var concatCommand = "-i \"concat:$outputts1|$outputts2\" -c copy " + getVideoClipSaveParent() + "concat_ts_video.mp4"
//            Log.d("edit_video_log","VideoEditorManager  concatCommand :$concatCommand")
//
//            val result = FFmpeg.execute(concatCommand)
//            Log.d("edit_video_log","VideoEditorManager  result :$result")
//            Log.d("edit_video_log","VideoEditorManager finish ")
//
//            /*************************************end  先转成ts再合并，但是视频的分辨率依然被缩放了**********************************************/


            /**+++++++++++++++++++++++++++++++++++++写本地文件，然后再读取文件列表合并，视频分辨率依然被改变了+++++++++++++++++++++++++++++++++++++++++++++++**/
            val result = FFmpeg.execute("-f concat -safe 0 -i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/fileconcat.txt -c copy /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/concat_file.mp4")
            Log.d("edit_video_log","VideoEditorManager  result :$result")

            Log.d("edit_video_log","VideoEditorManager finish ")
            /**+++++++++++++++++++++++++++++++++++++写本地文件，然后再读取文件列表合并，视频分辨率依然被改变了+++++++++++++++++++++++++++++++++++++++++++++++**/


        }
    }

    fun printVideoInfo() {
        val input1 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1scale_1722995979106.mp4"
        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo1: ***********")

        val inputInfo1 = FFmpeg.execute(input1)
        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo1: $inputInfo1")

        val input2 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1scale_1723032638188.mp4"
        val inputInfo2 = FFmpeg.execute(input2)
        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo2: $inputInfo2")


//        val input1 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2clip_1722995979106.mp4"
//        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo1: ***********")
//
//        val inputInfo1 = FFmpeg.execute(input1)
//        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo1: $inputInfo1")
//        val output1 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2scale_1722995979106.mp4"
//        Log.d("edit_video_log","VideoEditorManager printVideoInfo outpuInfo1: ###########")
//        val outpuInfo1 = FFmpeg.execute(output1)
//        Log.d("edit_video_log","VideoEditorManager printVideoInfo outpuInfo1: $outpuInfo1")
//
//        val input2 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2clip_1723032638188.mp4"
//        val inputInfo2 = FFmpeg.execute(input2)
//        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo2: $inputInfo2")
//
//        val output2 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2scale_1723032638188.mp4"
//        val outpuInfo2 = FFmpeg.execute(output2)
//        Log.d("edit_video_log","VideoEditorManager printVideoInfo outpuInfo2: $outpuInfo2")

    }

    fun scaleVideo() {

        var screenWidth = MyApplication.instance.getScreenWidth()
        if (screenWidth % 2 != 0) {
            screenWidth += 1
        }
        var screenHeight = MyApplication.instance.getScreenHeight()
        if (screenHeight % 2 != 0) {
            screenHeight += 1
        }
        var input1 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1clip_1722995979106.mp4"
        var output1 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1scale_1722995979106.mp4"

//        val command1 = "-i $input1 -vf scale=$screenWidth:$screenHeight -vcodec h264 $output1"
//        val command1 = "-i $input1 -vcodec h264 $output1"
        val command1 = "-i $input1 -s $screenWidth$screenHeight -b 500k -vcodec h264 -r 29.97 -ab 48k -ac 2 $output1"

//        val command = arrayOf("-i", "$input1", "-c:v", "libx264", "-s $screenWidth$screenHeight","-c:a", "aac", "$output1")
        val command = "-i $input1 -vf \"scale=$screenWidth:$screenHeight\" -c:v libx264 -preset fast -crf 23 -c:a copy $output1"
        val scale1 = FFmpeg.execute(command)
        Log.d("edit_video_log","VideoEditorManager scaleVideo ####### scale1: $scale1, command1: $command")


        var input2 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1clip_1723032638188.mp4"
        var output2 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/1scale_1723032638188.mp4"

//        val command = arrayOf("-i", "$input1", "-c:v", "libx264", "-s $screenWidth$screenHeight","-c:a", "aac", "$output1")
//        val command2 = "-i $input2 -vf \"scale=$screenWidth:$screenHeight\" -c:v libx264 -preset fast -crf 23 -c:a copy $output2"
        val command2 = "-i $input2 -vf \"scale=$screenWidth:-1, pad=$screenWidth:$screenHeight:(ow-iw)/2:0:red\" -c:a copy $output2"

        val scale2 = FFmpeg.execute(command2)
        Log.d("edit_video_log","VideoEditorManager scaleVideo ####### scale2: $scale2, command2: $command2")


//        /**+++++++++++++++++++++++++++++++++++++ scale 转换后视频质量太低 +++++++++++++++++++++++++++++++++++++++++++++++**/
//        Log.d("edit_video_log","VideoEditorManager scaleVideo start: ***********")
//
//        val screenWidth = MyApplication.instance.getScreenWidth()
//
//
////        var input1 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2clip_1722995979106.mp4"
////        var output1 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2scale_1722995979106.mp4"
////        val command1 = "-i $input1 -vf \"scale=$screenWidth:-1\" -c:v -c:a copy $output1"
//////        val command1 = "-i $input1 -vf scale=$screenWidth:-1, pad=iw+(ow-iw)/2:(ow-iw)/2:0x000000 -preset slow -crf 18 $output1"
//////        val command1 = "-i $input1 -vf \"scale=iw*9/16:ih\" -c:a copy $output1"
////        val scale1 = FFmpeg.execute(command1)
////        Log.d("edit_video_log","VideoEditorManager scaleVideo scale1: $scale1, command1: $command1")
//
//
//
//        var input2 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2clip_1723032638188.mp4"
//        var output2 = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/2scale_1723032638188.mp4"
//        val command2 = "-i $input2 -vf scale=$screenWidth:-1 -c:a $output2"
//
//        val scale2 = FFmpeg.execute(command2)
//        Log.d("edit_video_log","VideoEditorManager scaleVideo scale2: $scale2, command2: $command2")
//        /**+++++++++++++++++++++++++++++++++++++ scale 转换后视频质量太低 +++++++++++++++++++++++++++++++++++++++++++++++**/

    }

    fun clipAndMergeVideo(videoClipList: List<VideoClip>) {
                clipVideoMap.clear()
        for (videoClip in videoClipList) {
            Log.d("edit_video_log","VideoEditorManager videoClip detail: $videoClip")

//            ffmpeg -i input.mp4 -ss 00:00:10.000 -to 00:00:20.000 -c copy output.mp4
            val cmd = StringBuffer()
            cmd.append("-i ")
            cmd.append(videoClip.originalFilePath)
            cmd.append(" -ss ")
            cmd.append(formatDuration(videoClip.startAtMs))
            cmd.append(" -to ")
            cmd.append(formatDuration(videoClip.endAtMs))

//            val screenWidth = MyApplication.instance.getScreenWidth()
//            cmd.append(" -vf scale=$screenWidth:-1 ") // 导出视频的时候设置分辨率一致
            cmd.append(" -c ")
            cmd.append("copy ")
            var outputPath = getVideoClipSaveParent() + "1clip_" +videoClip.videoFileName
            cmd.append(outputPath)
            val executeId = FFmpeg.executeAsync(cmd.toString(), this@VideoEditorManager)
            clipVideoMap[executeId] = outputPath
            Log.d("edit_video_log","VideoEditorManager clip executeId:$executeId,  command: $cmd")

        }
    }

    override fun apply(executionId: Long, returnCode: Int) {
        Log.d("edit_video_log","VideoEditorManager apply callback, $executionId, $returnCode, ")
        if (clipVideoMap.containsKey(executionId) && returnCode == 0) {
            val outputFile = File(clipVideoMap[executionId])
            if (!outputFile.exists()) {
                Log.d("edit_video_log","VideoEditorManager apply callback file not exist, $executionId, $returnCode, ")
                return
            }

            clipedVideoMap[executionId] = clipVideoMap[executionId]!!

            val progress = (clipedVideoMap.size * 100 / clipVideoMap.size * CLIP_WEIGHT).toInt()
//            RxBus.getDefault().post(EditVideoEvent(progress, false)) // 除了post通知外，也需要本地保存，以方便publishActivity自取
            Log.d("edit_video_log","VideoEditorManager apply progress: $progress, false")

            if (clipVideoMap.size == clipedVideoMap.size) {

//                ffmpeg -i "concat:input1.mp4|input2.mp4|input3.mp4" -c copy output.mp4

                val cmd = StringBuffer()
                cmd.append("-i ")
                cmd.append("\"concat:")
                for (clipedVideoPath in clipedVideoMap.values) {
                    cmd.append(clipedVideoPath)
                    cmd.append("|")
                }
                cmd.append("\" -c ")
                cmd.append("copy ")
                cmd.append(getVideoClipSaveParent() + "concat_video.mp4")
                Log.d("edit_video_log","VideoEditorManager all video has cliped, start concat video command:$cmd")
                concatVideoId = FFmpeg.executeAsync(cmd.toString(), this@VideoEditorManager)
            }
        } else if (concatVideoId == executionId) {
            if (returnCode != 0) {
                Log.d("edit_video_log","VideoEditorManager clip and concat video failed~!")

            } else {
//                RxBus.getDefault().post(EditVideoEvent(100, true))
                Log.d("edit_video_log","VideoEditorManager apply progress: 100, true")

                Log.d("edit_video_log","VideoEditorManager clip and concat video success")
//                ToastHelper.show("clip and concat success~~~~")
            }
        }
    }

    private var concatVideoId: Long = -1

    private fun formatDuration(duration: Long): String {
        val hours = duration / (1000 * 60 * 60)
        val minutes = (duration / (1000 * 60)) % 60
        val seconds = (duration / 1000) % 60
        val milliseconds = duration % 1000

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds)
    }

    private fun getVideoClipSaveParent(): String{
        var rootDir = MyApplication.instance.externalCacheDir?.absolutePath ?: ""
        if (rootDir.isEmpty()) {
            rootDir = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache"
        }

        val parentFile = File(rootDir + File.separator + CLIP_VIDEO_DIR)
        if (!parentFile.exists()) {
            parentFile.mkdirs()
        }

        return parentFile.absolutePath + File.separator
    }

}