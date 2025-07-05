package com.example.tenanttrack.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = White,
    secondary = LightBlue,
    onSecondary = Black,
    tertiary = Green,
    onTertiary = Black,
    background = Gray900,
    onBackground = White,
    surface = Gray600,
    onSurface = White,
    error = Error,
    onError = White,
    outline = Gray400
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,               // Chủ đạo: nút, liên kết
    onPrimary = White,            // Text/Icon trên primary

    secondary = LightBlue,        // Màu phụ, ví dụ các tag
    onSecondary = Gray900,        // Text trên secondary

    tertiary = Green,             // Màu bổ sung, có thể dùng cho trạng thái thành công
    onTertiary = White,           // Text trên tertiary

    background = Gray50,          // Nền của toàn bộ app
    onBackground = Gray900,       // Text chính trên background

    surface = White,              // Màu nền của card, sheet, dialog
    onSurface = Gray900,          // Text trên surface
    onSurfaceVariant = Gray400,

    error = Error,                // Màu thông báo lỗi
    onError = White,              // Text trên nền error

    outline = Gray200             // Đường viền, border
)



@Composable
fun TenantTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}