package com.example.fonarik

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.util.Log

class ToggleFlashlightReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("Flash", "Вызван метод включения фонарика")
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]

        val isFlashOn = FlashlightState.isFlashOn
        cameraManager.setTorchMode(cameraId, !isFlashOn)
        FlashlightState.isFlashOn = !isFlashOn
    }
}

object FlashlightState {
    var isFlashOn = false
}
