package com.example.tenanttrack.domain.utils

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import com.yalantis.ucrop.UCrop
import java.io.File

object CropUtils {

    /**
     * Create a uCrop intent to crop an image with 10:2 (width:height) ratio.
     *
     * @param context       Android context (usually Activity or Composable’s context)
     * @param sourceUri     Uri of the selected image
     * @return              Intent to launch uCrop
     */
    fun getCropIntent(context: Context, sourceUri: Uri): Intent {
        val destinationUri = Uri.fromFile(
            File(context.cacheDir, "cropped_${System.currentTimeMillis()}.jpg")
        )

        val options = UCrop.Options().apply {
            setFreeStyleCropEnabled(false) // Lock aspect ratio
            setStatusBarColor(Color.DKGRAY)
            setRootViewBackgroundColor(Color.GRAY)
            setActiveControlsWidgetColor(Color.WHITE)
            setCompressionQuality(60)
        }

        return UCrop.of(sourceUri, destinationUri)
            .withAspectRatio(10f, 3f)
            .withMaxResultSize(2000, 400)
            .withOptions(options)
            .getIntent(context)
    }

    /**
     * Extracts cropped Uri from uCrop result Intent.
     */
    fun getCroppedUri(data: Intent?): Uri? {
        return data?.let { UCrop.getOutput(it) }
    }
}