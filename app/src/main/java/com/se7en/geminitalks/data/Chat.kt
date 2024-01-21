package com.se7en.geminitalks.data

import android.graphics.Bitmap

data class Chat (
    var prompt: String,
    var bitmap: Bitmap?,
    var isFromUser: Boolean
)