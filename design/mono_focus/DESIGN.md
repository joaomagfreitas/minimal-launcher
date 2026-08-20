---
name: Mono-Focus
colors:
  surface: '#121414'
  surface-dim: '#121414'
  surface-bright: '#383939'
  surface-container-lowest: '#0d0e0f'
  surface-container-low: '#1b1c1c'
  surface-container: '#1f2020'
  surface-container-high: '#292a2a'
  surface-container-highest: '#343535'
  on-surface: '#e3e2e2'
  on-surface-variant: '#c4c7c8'
  inverse-surface: '#e3e2e2'
  inverse-on-surface: '#303031'
  outline: '#8e9192'
  outline-variant: '#444748'
  surface-tint: '#c6c6c7'
  primary: '#ffffff'
  on-primary: '#2f3131'
  primary-container: '#e2e2e2'
  on-primary-container: '#636565'
  inverse-primary: '#5d5f5f'
  secondary: '#c8c6c5'
  on-secondary: '#313030'
  secondary-container: '#474746'
  on-secondary-container: '#b7b5b4'
  tertiary: '#ffffff'
  on-tertiary: '#2f3131'
  tertiary-container: '#e2e2e2'
  on-tertiary-container: '#636565'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#e2e2e2'
  primary-fixed-dim: '#c6c6c7'
  on-primary-fixed: '#1a1c1c'
  on-primary-fixed-variant: '#454747'
  secondary-fixed: '#e5e2e1'
  secondary-fixed-dim: '#c8c6c5'
  on-secondary-fixed: '#1c1b1b'
  on-secondary-fixed-variant: '#474746'
  tertiary-fixed: '#e2e2e2'
  tertiary-fixed-dim: '#c6c6c7'
  on-tertiary-fixed: '#1a1c1c'
  on-tertiary-fixed-variant: '#454747'
  background: '#121414'
  on-background: '#e3e2e2'
  surface-variant: '#343535'
typography:
  headline-lg:
    fontFamily: Hanken Grotesk
    fontSize: 48px
    fontWeight: '300'
    lineHeight: 56px
    letterSpacing: -0.02em
  headline-md:
    fontFamily: Hanken Grotesk
    fontSize: 32px
    fontWeight: '400'
    lineHeight: 40px
    letterSpacing: -0.01em
  body-lg:
    fontFamily: Hanken Grotesk
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
    letterSpacing: 0.01em
  body-md:
    fontFamily: Hanken Grotesk
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
    letterSpacing: 0.01em
  label-lg:
    fontFamily: Hanken Grotesk
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.05em
  label-sm:
    fontFamily: Hanken Grotesk
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
    letterSpacing: 0.05em
spacing:
  margin-page: 2rem
  gutter-list: 1.5rem
  stack-sm: 0.5rem
  stack-md: 1rem
  stack-lg: 3rem
---

## Brand & Style

The design system is built for a hyper-minimalist Android launcher experience. It targets users seeking digital mindfulness and a distraction-free mobile environment. By eliminating all iconography, the UI forces a shift from visual recognition to intentional reading.

The aesthetic is **Strict Minimalism** mixed with **Modern Typography-Driven Design**. The primary emotional response should be one of calm, clarity, and uncompromising focus. There are no shadows, no gradients, and no organic textures—only pure light against an absolute void.

## Colors

This design system utilizes an absolute monochrome palette. The background is pinned to `#000000` to take full advantage of OLED displays, effectively "disappearing" the hardware boundaries.

- **Primary**: Pure white (`#FFFFFF`) for all active text and essential UI markers.
- **Secondary**: Deep charcoal (`#1A1A1A`) for subtle containers or inactive states that require a slight lift from the background.
- **Neutral**: Mid-grey (`#808080`) for secondary information, metadata, and timestamps to maintain hierarchy without visual clutter.

## Typography

The design system relies entirely on **Hanken Grotesk** to convey meaning. It is a clean, sharp, and contemporary sans-serif that remains legible even at small scales. 

- **Headlines**: Used for the clock or primary dashboard views. Light weights (`300`) are preferred at large sizes to maintain a sophisticated feel.
- **App Listings**: Should use `body-lg` with standard weight. The lack of icons requires the text to have enough presence to be easily tappable.
- **System Info**: Labels should use uppercase styling with increased letter spacing to create a distinct visual "zone" for metadata vs. interactive elements.

## Layout & Spacing

The layout is a **Fixed Margin** model. Everything is anchored to a generous 32px (`2rem`) safe area on the left and right. This creates a vertical "spine" for the text to sit on.

- **Vertical Rhythm**: Spacing between app names in the list is intentionally large (`1.5rem` / `24px`) to prevent accidental taps and ensure the eye can rest on a single item.
- **Top-Heavy Layout**: The primary time/date information is positioned in the top third of the screen, leaving the bottom two-thirds for a scrollable app list. 
- **Reflow**: On tablet devices, the list remains centered with a max-width of 600px rather than stretching, preserving the vertical scanning pattern.

## Elevation & Depth

This design system rejects all physical metaphors of depth. There are no shadows or blurs. 

Hierarchy is established through **Contrast and Tonal Layers**:
- **Layer 0**: The background (`#000000`).
- **Layer 1**: Subtle dividers or search bars using `#1A1A1A`. 
- **Active State**: When a list item is pressed, it should invert (White background with Black text) or show a subtle `#1A1A1A` block behind it.
- **Outlines**: If a border is necessary (e.g., for a search input), use a 1px solid `#FFFFFF` or `#1A1A1A` line. No soft edges.

## Shapes

The shape language is strictly **Sharp**. 

All interactive elements, selection states, and input fields must have 0px corner radii. This reinforces the "architectural" and "precise" nature of the design system. Rounded shapes are considered too friendly and organic for this specific utilitarian focus.

## Components

### App List Items
The core of the launcher. No icons. Just the text string of the app name.
- **Normal**: `body-lg`, White.
- **Pressed**: Background becomes White, text becomes Black.
- **Spacing**: 24px vertical padding between items.

### Search Bar
A minimal input field at the bottom of the screen.
- **Style**: 1px White bottom-border only. 
- **Placeholder**: `body-md`, Grey (`#808080`).
- **Text**: `body-md`, White.

### Buttons
Used only for settings or system prompts.
- **Primary**: Solid White box with Black `label-lg` text (Uppercase).
- **Secondary**: 1px White outline with White `label-lg` text.

### Chips / Filters
Used for categorizing apps (e.g., "Work", "Social").
- **Style**: Text-only with an underscore (`_`) prefix for the active state. No background pill shape.

### Clock & Date
- **Clock**: `headline-lg`, White, anchored to the top-left.
- **Date**: `label-sm`, Grey, positioned directly above or below the clock with `stack-sm` spacing.