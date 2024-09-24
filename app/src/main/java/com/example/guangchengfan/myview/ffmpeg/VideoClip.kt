package org.me.kevin.video.edit


/**
 * 视频美化视频片段
 * @author fgc
 * @since 2024年08月13日10:16:29
 */
data class VideoClip(
    var id: String, //唯一标识
    var originalFilePath: String,//文件路径
    var videoFileName: String,//文件名称
    var originalDurationMs: Long = 0,//原始文件时长
    var startAtMs: Long = 0, //视频有效起始时刻
    var endAtMs: Long = 0,//视频有效结束时刻
    var isSelected: Boolean = false, // 是否被选中
    var width: Int = 1,
    var height: Int = 1
){
    val durationMs: Long //视频有效播放时长，受节选、速度、转场吃掉时间影响
        get() {
            if (endAtMs <= startAtMs) {
                return 0
            }
            return endAtMs - startAtMs
        }

    override fun toString(): String {
        return "VideoClip(id='$id', originalFilePath='$originalFilePath', videoFileName='$videoFileName', originalDurationMs=$originalDurationMs, startAtMs=$startAtMs, endAtMs=$endAtMs, isSelected=$isSelected), width=$width, height=$height"
    }
}