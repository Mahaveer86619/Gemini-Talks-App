package com.se7en.geminitalks

import android.graphics.Bitmap
import com.se7en.geminitalks.data.Chat

data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)
