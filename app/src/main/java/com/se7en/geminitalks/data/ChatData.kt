package com.se7en.geminitalks.data

import android.graphics.Bitmap
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.ResponseStoppedException
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {

    val api_key = "AIzaSyA1JkWN5KALxzhIMLd-YVMiHCtz4MQB75k"

    suspend fun getResponse(prompt: String): Chat {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = api_key
        )

        try {

            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(prompt)
            }

            return Chat(
                prompt = response.text ?: "error responding",
                bitmap = null,
                isFromUser = false
            )

        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "error caught",
                bitmap = null,
                isFromUser = false
            )
        }

    }

    suspend fun getResponseWithBitmap(prompt: String, bitmap: Bitmap): Chat {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro-vision",
            apiKey = api_key
        )

        try {

            val content = content {
                image(bitmap)
                text(prompt)
            }

            val response = withContext(Dispatchers.IO){
                generativeModel.generateContent(content)
            }

            return Chat(
                prompt = response.text ?: "error responding",
                bitmap = null,
                isFromUser = false
            )

        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "error caught",
                bitmap = null,
                isFromUser = false
            )
        }

    }

}