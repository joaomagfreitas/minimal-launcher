package link.joaomagfreitas.minimal_launcher.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

// Mono-Focus color tokens

val neutral = Color(0xFF808080)
val danger = Color(0xFFb8847e)

val monoFocusDarkColorScheme =
    darkColorScheme(
        // Primary
        primary = Color(0xFFFFFFFF),
        onPrimary = Color(0xFF2F3131),
        primaryContainer = Color(0xFFE2E2E2),
        onPrimaryContainer = Color(0xFF636565),
        inversePrimary = Color(0xFF5D5F5F),

        // Secondary
        secondary = Color(0xFFC8C6C5),
        onSecondary = Color(0xFF313030),
        secondaryContainer = Color(0xFF474746),
        onSecondaryContainer = Color(0xFFB7B5B4),

        // Tertiary
        tertiary = Color(0xFFFFFFFF),
        onTertiary = Color(0xFF2F3131),
        tertiaryContainer = Color(0xFFE2E2E2),
        onTertiaryContainer = Color(0xFF636565),

        // Error
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF690005),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFDAD6),

        // Background
        background = Color(0xFF121414),
        onBackground = Color(0xFFE3E2E2),

        // Surface
        surface = Color(0xFF121414),
        onSurface = Color(0xFFE3E2E2),
        surfaceVariant = Color(0xFF343535),
        onSurfaceVariant = Color(0xFFC4C7C8),

        // Surface
        inverseSurface = Color(0xFFE3E2E2),
        inverseOnSurface = Color(0xFF303031),
        surfaceTint = Color(0xFFC6C6C7),

        // Outline
        outline = Color(0xFF8E9192),
        outlineVariant = Color(0xFF444748),

        // Scrim
        scrim = Color(0xFF000000),

        // Surface container roles
        surfaceDim = Color(0xFF121414),
        surfaceBright = Color(0xFF383939),
        surfaceContainerLowest = Color(0xFF0D0E0F),
        surfaceContainerLow = Color(0xFF1B1C1C),
        surfaceContainer = Color(0xFF1F2020),
        surfaceContainerHigh = Color(0xFF292A2A),
        surfaceContainerHighest = Color(0xFF343535),

        // Primary fixed
        primaryFixed = Color(0xFFE2E2E2),
        primaryFixedDim = Color(0xFFC6C6C7),
        onPrimaryFixed = Color(0xFF1A1C1C),
        onPrimaryFixedVariant = Color(0xFF454747),

        // Secondary fixed
        secondaryFixed = Color(0xFFE5E2E1),
        secondaryFixedDim = Color(0xFFC8C6C5),
        onSecondaryFixed = Color(0xFF1C1B1B),
        onSecondaryFixedVariant = Color(0xFF474746),

        // Tertiary fixed
        tertiaryFixed = Color(0xFFE2E2E2),
        tertiaryFixedDim = Color(0xFFC6C6C7),
        onTertiaryFixed = Color(0xFF1A1C1C),
        onTertiaryFixedVariant = Color(0xFF454747),
    )
