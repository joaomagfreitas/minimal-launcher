package link.joaomagfreitas.minimal_launcher.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import link.joaomagfreitas.minimal_launcher.R

private val hankenGroteskFontFamily =
    FontFamily(
        Font(R.font.hanken_grotesk_black, FontWeight.Black),
        Font(R.font.hanken_grotesk_black_italic, FontWeight.Black, style = FontStyle.Italic),
        Font(R.font.hanken_grotesk_extra_bold, FontWeight.ExtraBold),
        Font(
            R.font.hanken_grotesk_extra_bold_italic,
            FontWeight.ExtraBold,
            style = FontStyle.Italic,
        ),
        Font(R.font.hanken_grotesk_bold, FontWeight.Bold),
        Font(R.font.hanken_grotesk_bold_italic, FontWeight.Bold, style = FontStyle.Italic),
        Font(R.font.hanken_grotesk_semi_bold, FontWeight.SemiBold),
        Font(R.font.hanken_grotesk_semi_bold_italic, FontWeight.SemiBold, style = FontStyle.Italic),
        Font(R.font.hanken_grotesk_medium, FontWeight.Medium),
        Font(R.font.hanken_grotesk_medium_italic, FontWeight.Medium, style = FontStyle.Italic),
        Font(R.font.hanken_grotesk_regular, FontWeight.Normal),
        Font(R.font.hanken_grotesk_regular_italic, FontWeight.Normal, style = FontStyle.Italic),
        Font(R.font.hanken_grotesk_light, FontWeight.Light),
        Font(R.font.hanken_grotesk_light_italic, FontWeight.Light, style = FontStyle.Italic),
        Font(R.font.hanken_grotesk_extra_light, FontWeight.ExtraLight),
        Font(
            R.font.hanken_grotesk_extra_light_italic,
            FontWeight.ExtraLight,
            style = FontStyle.Italic,
        ),
        Font(R.font.hanken_grotesk_thin, FontWeight.Thin),
        Font(R.font.hanken_grotesk_thin_italic, FontWeight.Thin, style = FontStyle.Italic),
    )

val Typography =
    Typography(
        bodySmall =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp,
                letterSpacing = (-0.01).em,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.01.em,
            ),
        titleSmall =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        titleMedium =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        titleLarge =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        labelSmall =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp,
                letterSpacing = 0.05.em,
            ),
        labelMedium =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        labelLarge =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp,
                letterSpacing = 0.05.em,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 40.sp,
                letterSpacing = (-0.01).em,
            ),
        headlineLarge =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
                fontSize = 48.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 56.sp,
                letterSpacing = (-0.02).em,
            ),
        displaySmall =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        displayMedium =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
        displayLarge =
            TextStyle(
                fontFamily = hankenGroteskFontFamily,
            ),
    )
