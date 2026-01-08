package com.mikewilcome.kmpblogsite.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmpblogsite.composeapp.generated.resources.Res
import kmpblogsite.composeapp.generated.resources.fraunces_semibold
import kmpblogsite.composeapp.generated.resources.inter_medium
import kmpblogsite.composeapp.generated.resources.inter_regular
import kmpblogsite.composeapp.generated.resources.inter_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun appTypography(): Typography {
    val uiFamily = FontFamily(
        Font(Res.font.inter_regular, weight = FontWeight.Normal),
        Font(Res.font.inter_medium, weight = FontWeight.Medium),
        Font(Res.font.inter_semibold, weight = FontWeight.SemiBold)
    )

    val displayFamily = FontFamily(
        Font(Res.font.fraunces_semibold, weight = FontWeight.SemiBold)
    )

    return Typography(
            displayLarge = TextStyle(
                fontFamily = displayFamily,
                fontSize = 56.sp,
                lineHeight = 60.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = (-0.4).sp
            ),
            headlineSmall = TextStyle(
                fontFamily = displayFamily,
                fontSize = 26.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.SemiBold
            ),
            titleMedium = TextStyle(
                fontFamily = uiFamily,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.2.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = uiFamily,
                fontSize = 18.sp,
                lineHeight = 26.sp,
                fontWeight = FontWeight.Normal
            ),
            bodyMedium = TextStyle(
                fontFamily = uiFamily,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            )
        )
}
