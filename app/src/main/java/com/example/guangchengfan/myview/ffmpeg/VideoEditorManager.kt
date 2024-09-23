package org.me.kevin.utils.videoedit

import android.util.Log
import com.arthenica.mobileffmpeg.ExecuteCallback
import com.arthenica.mobileffmpeg.FFmpeg
import com.example.guangchengfan.myview.MyApplication
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.me.kevin.video.edit.VideoClip
import java.io.File

object VideoEditorManager: ExecuteCallback {
    override fun apply(executionId: Long, returnCode: Int) {
        Log.d("edit_video_log","VideoEditorManager apply callback, $executionId, $returnCode, ")

    }

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
        val input1 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/clip_1722995979106.mp4 /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/info1.txt"
        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo1: ***********")

        val inputInfo1 = FFmpeg.execute(input1)
        Log.d("edit_video_log","VideoEditorManager printVideoInfo inputInfo1: $inputInfo1")

        val input2 = "-i /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/clip_1723032638188.mp4 /storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache/zsj_clip_video_folder/info2.txt"
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
        val command2 = "-i $input2 -vf \"scale=$screenWidth:-1, pad=$screenWidth:$screenHeight:(ow-iw)/2:(oh-ih)/2:red\" -c:a copy $output2"

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

    fun clipVideo(videoClipList: List<VideoClip>) {
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
            var outputPath = getVideoSaveTempParent() + "1clip_" +videoClip.videoFileName
            cmd.append(outputPath)
            val executeId = FFmpeg.executeAsync(cmd.toString(), this@VideoEditorManager)
            Log.d("edit_video_log","VideoEditorManager clip executeId:$executeId,  command: $cmd")

        }
    }

    private fun formatDuration(duration: Long): String {
        val hours = duration / (1000 * 60 * 60)
        val minutes = (duration / (1000 * 60)) % 60
        val seconds = (duration / 1000) % 60
        val milliseconds = duration % 1000

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds)
    }

    private fun getVideoSaveTempParent(): String{
        var rootDir = MyApplication.instance.externalCacheDir?.absolutePath ?: ""
        if (rootDir.isEmpty()) {
            rootDir = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache"
        }

        val parentFile = File(rootDir + File.separator + EDIT_VIDEO_DIR)
        if (!parentFile.exists()) {
            parentFile.mkdirs()
        }

        return parentFile.absolutePath + File.separator
    }

    private fun getVideoOutputParent(): String{
        var rootDir = MyApplication.instance.externalCacheDir?.absolutePath ?: ""
        if (rootDir.isEmpty()) {
            rootDir = "/storage/emulated/0/Android/data/com.example.guangchengfan.myview/cache"
        }

        val parentFile = File(rootDir + File.separator + OUTPUT_VIDEO_DIR)
        if (!parentFile.exists()) {
            parentFile.mkdirs()
        }

        return parentFile.absolutePath + File.separator
    }


    /**---------------------editvideo-------------------------**/
    private const val EDIT_VIDEO_DIR: String = "zsj_edit_video_folder"
    private const val OUTPUT_VIDEO_DIR: String = "zsj_output_video_folder"
    // 视频裁剪占总操作的比重，即全部完成视频裁剪，占总进度的10%
    private const val CLIP_PROGRESS_WEIGHT = 0.1f
    // 视频分辨率转换占的总比在，即完成所有视频分辨率转换，占总进度的70%
    private const val SCALE_PROGRESS_WEIGHT = 0.7f
    // 视频拼接转换占的总比在，即完成所有视频拼接转换，占总进度的20%
    private const val CONCAT_PROGRESS_WEIGHT = 0.2f
    // todo fgc 进度暂定500ms更新加一，避免卡住不动的现象
    private const val PROGRESS_UPDATE_INTERVAL: Long = 500

    private var currentEditState: EditState = EditState.INIT

    private val clippedVideoList = ArrayList<VideoClip>()
    private val scaledVideoList = ArrayList<VideoClip>()
    private var mCurrentProgress: Float = 0f
    private var progressJob: Job? = null
    private var mTotalEditVideoSize: Int = 1
    private var mThumbnailImg: String = ""

    fun editVideos(videoClipList: List<VideoClip>) {
        try {
            if (videoClipList.isEmpty()) {
                Log.d("edit_video_log","VideoEditorManager editVideos: list is empty,just return")
                return
            }

            mTotalEditVideoSize = videoClipList.size
            currentEditState = EditState.INIT
            GlobalScope.launch {
                clippedVideoList.clear()
                scaledVideoList.clear()
                saveThumbnail(videoClipList)
            }
        } catch (e: Exception) {
            Log.d("edit_video_log","VideoEditorManager editVideos: error: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun saveThumbnail(videoClipList: List<VideoClip>) {
        val videoClip = videoClipList[0]
        val cmd = StringBuffer()
        cmd.append("-i ")
        cmd.append(videoClip.originalFilePath)
        cmd.append(" -vf \"thumbnail\" -frames:v 1 ")
        val outputImg = getVideoOutputParent() + "edit_video_thumbnail.png"
        cmd.append(outputImg)
        val result = FFmpeg.execute(cmd.toString())
        if (result == 0) {
            mThumbnailImg = outputImg
            clipVideos(videoClipList)
        } else {
            onEditVideosFailed("save thumbnail failed!")
        }
    }

    private fun clipVideos(videoClipList: List<VideoClip>) {
        Log.d("edit_video_log","VideoEditorManager clipVideos: start")
        currentEditState = EditState.CLIPPING
        for (videoClip in videoClipList) {
//            ffmpeg -i input.mp4 -ss 00:00:10.000 -to 00:00:20.000 -c copy output.mp4
            val cmd = StringBuffer()
            cmd.append("-i ")
            cmd.append(videoClip.originalFilePath)
            cmd.append(" -ss ")
            cmd.append(formatDuration(videoClip.startAtMs))
            cmd.append(" -to ")
            cmd.append(formatDuration(videoClip.endAtMs))
            cmd.append(" -c ")
            cmd.append("copy ")
            val outputFileName = "clip_" +videoClip.videoFileName
            val outputPath = getVideoSaveTempParent() + outputFileName
            cmd.append(outputPath)
            // 开始执行，慢慢的增加进度
            startProgressUpdate()

            val executeResult = FFmpeg.execute(cmd.toString())
            if (executeResult == 0) {
                val clippedVideoClip = VideoClip(
                    videoClip.id,
                    outputPath,
                    outputFileName,
                    videoClip.originalDurationMs,
                    videoClip.startAtMs,
                    videoClip.endAtMs,
                    videoClip.isSelected,
                    videoClip.width,
                    videoClip.height
                )
                clippedVideoList.add(clippedVideoClip)
                // 操作完成，更新当前进度
                updateProgressUpdate(clippedVideoList.size * 100 / mTotalEditVideoSize * CLIP_PROGRESS_WEIGHT)
            } else {
                onEditVideosFailed("clipVideos clip video failed id:${videoClip.id}")
                break
            }

            Log.d("edit_video_log","VideoEditorManager clipVideos $videoClip")
        }

        if (clippedVideoList.size == mTotalEditVideoSize) {
            scaleVideos(clippedVideoList)
        }
    }

    private fun scaleVideos(clippedVideos: List<VideoClip>) {
        currentEditState = EditState.SCALING
        var screenWidth = MyApplication.instance.getScreenWidth()
        if (screenWidth % 2 != 0) {
            screenWidth += 1
        }
        var screenHeight = MyApplication.instance.getScreenHeight()
        if (screenHeight % 2 != 0) {
            screenHeight += 1
        }

        for (videoClip in clippedVideos) {
            val inputFile: File = File(videoClip.originalFilePath)
            val outputFileName = "scale_" + inputFile.name
            var outputScalePath = getVideoSaveTempParent() + outputFileName
            // 开始执行，慢慢的增加进度
            startProgressUpdate()
            val  videoAspectRatio = videoClip.width.toFloat() / videoClip.height.toFloat()
            val screenAspectRatio = screenWidth.toFloat() / screenHeight.toFloat()
            val screenHwRatio = screenHeight.toFloat() / screenWidth.toFloat()


            // todo fgc 暂时用不同颜色进行 填充，晚点都改为黑色
            var scaleCommand = if (videoAspectRatio >= screenAspectRatio) {
                // 横屏 宽视频
                "-i ${inputFile.absolutePath} -vf pad=iw:iw*$screenHwRatio:0:(oh-ih)/2:blue $outputScalePath"
            } else {
                // 竖屏 窄视频
                "-i ${inputFile.absolutePath} -vf pad=ih*$screenAspectRatio:ih:(ow-iw)/2:0:red $outputScalePath"
            }

            val executeResult = FFmpeg.execute(scaleCommand)
            Log.d("edit_video_log","scale command: $scaleCommand")

            if (executeResult == 0) {
                val scaledVideoClip = VideoClip(
                    videoClip.id,
                    outputScalePath,
                    outputFileName,
                    videoClip.originalDurationMs,
                    videoClip.startAtMs,
                    videoClip.endAtMs,
                    videoClip.isSelected,
                    videoClip.width,
                    videoClip.height
                )
                scaledVideoList.add(scaledVideoClip)
                // 操作完成，更新当前进度
                updateProgressUpdate(scaledVideoList.size * 100 / mTotalEditVideoSize * SCALE_PROGRESS_WEIGHT)
            } else {
                onEditVideosFailed("scale video failed path:${inputFile.name}")
                break
            }

            if (scaledVideoList.size == mTotalEditVideoSize) {
                concatVideos(scaledVideoList)
            }

            Log.d("edit_video_log","VideoEditorManager scaleVideos $outputScalePath")
        }
    }

    private fun concatVideos(scaledVideos: List<VideoClip>) {
        try {
            currentEditState = EditState.CONCATING
            var concatFile = File(getVideoSaveTempParent() + "concatFileList.txt")
            if (concatFile.exists()) {
                concatFile.delete()
            }

            concatFile.createNewFile()
            var concatFileContent = StringBuffer()
            for (videoClip in scaledVideos) {
                concatFileContent.append("file '")
                concatFileContent.append(videoClip.originalFilePath)
                concatFileContent.append("'\n")
            }
            concatFile.writeText(concatFileContent.toString())

            // 导出视频，放在getOutputParent 目录下
            val outputFile = File(getVideoOutputParent() + "concat_file.mp4")
            val concatCommand = "-f concat -safe 0 -i ${concatFile.absolutePath} -c copy ${outputFile.absolutePath}"
            startProgressUpdate()
            val result = FFmpeg.execute(concatCommand)
            Log.d("edit_video_log","concat command: $concatCommand, result:$result")
            if (result == 0) {
                updateProgressUpdate(CONCAT_PROGRESS_WEIGHT * 100)
                Log.d("edit_video_log","concat success,edit video finish: ${outputFile.absolutePath}")
                currentEditState = EditState.FINISHED

                // 删除产生的临时文件
                val editTmpFileDir = File(getVideoSaveTempParent())
                if (editTmpFileDir.exists()) {
                    editTmpFileDir.deleteRecursively()
                }
            } else {
                onEditVideosFailed("concat video failed filelist:${concatFile.name}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            onEditVideosFailed("concat video exception!")
        }
    }

    private fun getMaxProgress(): Float {
        if (currentEditState == EditState.CLIPPING) {
            return getClipMaxProgress()
        } else if (currentEditState == EditState.SCALING) {
            return getClipMaxProgress() + getScaleMaxProgress()
        } else if (currentEditState == EditState.CONCATING) {
            return getClipMaxProgress() + getScaleMaxProgress() + getConcatMaxProgress()
        }
        return 100.0f
    }

    private fun getScaleMaxProgress(): Float {
        var currentSize = scaledVideoList.size + 1
        if (currentSize > mTotalEditVideoSize) {
            currentSize = mTotalEditVideoSize
        }
        return currentSize * 100 / mTotalEditVideoSize * SCALE_PROGRESS_WEIGHT
    }

    private fun getConcatMaxProgress(): Float {
        return CONCAT_PROGRESS_WEIGHT * 100
    }

    private fun getClipMaxProgress(): Float {
        var currentSize = clippedVideoList.size + 1
        if (currentSize > mTotalEditVideoSize) {
            currentSize = mTotalEditVideoSize
        }
        return currentSize * 100 / mTotalEditVideoSize * CLIP_PROGRESS_WEIGHT
    }

    /**
     * currentProgress 当前阶段的进度，因此updateProgressUpdate 里面需要根据当前阶段计算总进度
     */
    private fun updateProgressUpdate(currentProgress: Float) {
        var baseProgress = 0f
        baseProgress = when (currentEditState) {
            EditState.CLIPPING -> {
                0f
            }

            EditState.SCALING -> {
                CLIP_PROGRESS_WEIGHT * 100
            }

            EditState.CONCATING -> {
                CLIP_PROGRESS_WEIGHT * 100 + SCALE_PROGRESS_WEIGHT * 100
            }

            else -> {
                0f
            }
        }
        mCurrentProgress = baseProgress + currentProgress
        Log.d("edit_video_log","VideoEditorManager updateProgressUpdate: $mCurrentProgress")
        startProgressUpdate()
    }
    private fun startProgressUpdate() {
        progressJob?.cancel()
        progressJob = GlobalScope.launch {
            while (true) {
                delay(PROGRESS_UPDATE_INTERVAL)
                if (mCurrentProgress < getMaxProgress()) {
                    mCurrentProgress += 1
                } else {
                    break
                }
                // 持续更新progress，避免一直卡住的现象
                Log.d("edit_video_log","VideoEditorManager startProgressUpdate: $mCurrentProgress")
            }
        }
    }

    private fun onEditVideosFailed(msg: String = "-") {
        // todo fgc 停止编辑视频，通知任务失败相关的逻辑，并且删除相关过程中间产物
        Log.d("edit_video_log","VideoEditorManager apply callback, editvideos failed, $msg")

    }

    enum class EditState {
        INIT,
        CLIPPING,
        SCALING,
        CONCATING,
        FINISHED
    }

}