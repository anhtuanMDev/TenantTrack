package com.example.tenanttrack.presentation.setting_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.tenanttrack.R
import com.example.tenanttrack.ui.theme.Blue
import com.example.tenanttrack.ui.theme.Gray200
import com.example.tenanttrack.ui.theme.Gray600
import com.example.tenanttrack.ui.theme.Green
import com.example.tenanttrack.ui.theme.LightBlue
import com.example.tenanttrack.ui.theme.Orange
import com.example.tenanttrack.ui.theme.Purple
import com.example.tenanttrack.ui.theme.Red
import com.example.tenanttrack.ui.theme.Violet
import com.example.tenanttrack.ui.theme.Yellow

@Composable
fun provideSettingSections(): List<SettingSection> {
    return listOf(
        SettingSection(
            title = stringResource(id = R.string.tab4_section1_header),
            items = listOf(
                SettingItem(
                    icon = R.drawable.chart_line,
                    title = stringResource(R.string.tab4_section1_title1),
                    subtitle = stringResource(R.string.tab4_section1_subtitle1),
                    tint = Blue,
                    backgroundIcon = LightBlue
                ),
                SettingItem(
                    icon = R.drawable.chart_no_axes_column,
                    title = stringResource(R.string.tab4_section1_title2),
                    subtitle = stringResource(R.string.tab4_section1_subtitle2),
                    tint = Green,
                    backgroundIcon = Green.copy(alpha = 0.05f)
                ),
                SettingItem(
                    icon = R.drawable.tenants,
                    title = stringResource(R.string.tab4_section1_title3),
                    subtitle = stringResource(R.string.tab4_section1_subtitle3),
                    tint = Orange,
                    backgroundIcon = Orange.copy(alpha = 0.05f)
                )
            )
        ),
        SettingSection(
            title = stringResource(id = R.string.tab4_section2_header),
            items = listOf(
                SettingItem(
                    icon = R.drawable.file_text,
                    title = stringResource(R.string.tab4_section2_title1),
                    subtitle = stringResource(R.string.tab4_section2_subtitle1),
                    tint = Violet,
                    backgroundIcon = Violet.copy(alpha = 0.05f),
                    trailingIcon = R.drawable.download
                ),
                SettingItem(
                    icon = R.drawable.table,
                    title = stringResource(R.string.tab4_section2_title2),
                    subtitle = stringResource(R.string.tab4_section2_subtitle2),
                    tint = Purple,
                    backgroundIcon = Purple.copy(alpha = 0.05f),
                    trailingIcon = R.drawable.download
                )
            )
        ),
        SettingSection(
            title = stringResource(id = R.string.tab4_section3_header),
            items = listOf(
                SettingItem(
                    icon = R.drawable.settings,
                    title = stringResource(R.string.tab4_section3_title1),
                    subtitle = stringResource(R.string.tab4_section3_subtitle1),
                    tint = Gray600,
                    backgroundIcon = Gray200
                )
            )
        ),
        SettingSection(
            title = stringResource(id = R.string.tab4_section4_header),
            items = listOf(
                SettingItem(
                    icon = R.drawable.circle_help,
                    title = stringResource(R.string.tab4_section4_title1),
                    subtitle = stringResource(R.string.tab4_section4_subtitle1),
                    tint = Yellow,
                    backgroundIcon = Yellow.copy(alpha = 0.05f)
                ),
                SettingItem(
                    icon = R.drawable.headphones,
                    title = stringResource(R.string.tab4_section4_title2),
                    subtitle = stringResource(R.string.tab4_section4_subtitle2),
                    tint = Red,
                    backgroundIcon = Red.copy(alpha = 0.05f)
                ),
                SettingItem(
                    icon = R.drawable.info,
                    title = stringResource(R.string.tab4_section4_title3),
                    subtitle = stringResource(R.string.tab4_section4_subtitle3),
                    tint = Gray600,
                    backgroundIcon = Gray200
                )
            )
        )
    )
}
