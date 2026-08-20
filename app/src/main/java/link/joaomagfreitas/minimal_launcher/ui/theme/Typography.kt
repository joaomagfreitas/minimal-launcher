package link.joaomagfreitas.minimal_launcher.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import link.joaomagfreitas.minimal_launcher.R

private val hankenGroteskFontFamily = FontFamily(
    Font(R.font.hanken_grotesk_black, FontWeight.Black),
    Font(R.font.hanken_grotesk_black_italic, FontWeight.Black, style = FontStyle.Italic),
    Font(R.font.hanken_grotesk_extra_bold, FontWeight.ExtraBold),
    Font(R.font.hanken_grotesk_extra_bold_italic, FontWeight.ExtraBold, style = FontStyle.Italic),
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
    Font(R.font.hanken_grotesk_extra_light_italic, FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(R.font.hanken_grotesk_thin, FontWeight.Thin),
    Font(R.font.hanken_grotesk_thin_italic, FontWeight.Thin, style = FontStyle.Italic),
)

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    bodyMedium = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    bodyLarge = TextStyle(
        fontFamily = hankenGroteskFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    titleMedium = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    titleLarge = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    labelSmall = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    labelMedium = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    labelLarge = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    headlineSmall = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    headlineMedium = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    headlineLarge = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    displaySmall = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    displayMedium = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
    displayLarge = TextStyle(
        fontFamily = hankenGroteskFontFamily
    ),
)