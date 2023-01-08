package com.ntq.basejetpackcompose.core.manager.ads_manager.native

import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import androidx.annotation.Nullable
import com.google.errorprone.annotations.CanIgnoreReturnValue


class NativeTemplateStyle {
    // Call to action typeface.
    private var callToActionTextTypeface: Typeface? = null

    // Size of call to action text.
    private var callToActionTextSize = 0f

    // Call to action typeface color in the form 0xAARRGGBB.
    @Nullable
    private var callToActionTypefaceColor: Int? = null

    // Call to action background color.
    private var callToActionBackgroundColor: ColorDrawable? = null

    // All templates have a primary text area which is populated by the native ad's headline.

    // All templates have a primary text area which is populated by the native ad's headline.
    // Primary text typeface.
    private var primaryTextTypeface: Typeface? = null

    // Size of primary text.
    private var primaryTextSize = 0f

    // Primary text typeface color in the form 0xAARRGGBB.
    @Nullable
    private var primaryTextTypefaceColor: Int? = null

    // Primary text background color.
    private var primaryTextBackgroundColor: ColorDrawable? = null

    // The typeface, typeface color, and background color for the second row of text in the template.
    // All templates have a secondary text area which is populated either by the body of the ad or
    // by the rating of the app.

    // The typeface, typeface color, and background color for the second row of text in the template.
    // All templates have a secondary text area which is populated either by the body of the ad or
    // by the rating of the app.
    // Secondary text typeface.
    private var secondaryTextTypeface: Typeface? = null

    // Size of secondary text.
    private var secondaryTextSize = 0f

    // Secondary text typeface color in the form 0xAARRGGBB.
    @Nullable
    private var secondaryTextTypefaceColor: Int? = null

    // Secondary text background color.
    private var secondaryTextBackgroundColor: ColorDrawable? = null

    // The typeface, typeface color, and background color for the third row of text in the template.
    // The third row is used to display store name or the default tertiary text.

    // The typeface, typeface color, and background color for the third row of text in the template.
    // The third row is used to display store name or the default tertiary text.
    // Tertiary text typeface.
    private var tertiaryTextTypeface: Typeface? = null

    // Size of tertiary text.
    private var tertiaryTextSize = 0f

    // Tertiary text typeface color in the form 0xAARRGGBB.
    @Nullable
    private var tertiaryTextTypefaceColor: Int? = null

    // Tertiary text background color.
    private var tertiaryTextBackgroundColor: ColorDrawable? = null

    // The background color for the bulk of the ad.
    private var mainBackgroundColor: ColorDrawable? = null

    fun getCallToActionTextTypeface(): Typeface? {
        return callToActionTextTypeface
    }

    fun getCallToActionTextSize(): Float {
        return callToActionTextSize
    }

    @Nullable
    fun getCallToActionTypefaceColor(): Int? {
        return callToActionTypefaceColor
    }

    fun getCallToActionBackgroundColor(): ColorDrawable? {
        return callToActionBackgroundColor
    }

    fun getPrimaryTextTypeface(): Typeface? {
        return primaryTextTypeface
    }

    fun getPrimaryTextSize(): Float {
        return primaryTextSize
    }

    @Nullable
    fun getPrimaryTextTypefaceColor(): Int? {
        return primaryTextTypefaceColor
    }

    fun getPrimaryTextBackgroundColor(): ColorDrawable? {
        return primaryTextBackgroundColor
    }

    fun getSecondaryTextTypeface(): Typeface? {
        return secondaryTextTypeface
    }

    fun getSecondaryTextSize(): Float {
        return secondaryTextSize
    }

    @Nullable
    fun getSecondaryTextTypefaceColor(): Int? {
        return secondaryTextTypefaceColor
    }

    fun getSecondaryTextBackgroundColor(): ColorDrawable? {
        return secondaryTextBackgroundColor
    }

    fun getTertiaryTextTypeface(): Typeface? {
        return tertiaryTextTypeface
    }

    fun getTertiaryTextSize(): Float {
        return tertiaryTextSize
    }

    @Nullable
    fun getTertiaryTextTypefaceColor(): Int? {
        return tertiaryTextTypefaceColor
    }

    fun getTertiaryTextBackgroundColor(): ColorDrawable? {
        return tertiaryTextBackgroundColor
    }

    fun getMainBackgroundColor(): ColorDrawable? {
        return mainBackgroundColor
    }

    /** A class that provides helper methods to build a style object.  */
    class Builder {
        private val styles: NativeTemplateStyle

        init {
            styles = NativeTemplateStyle()
        }

        @CanIgnoreReturnValue
        fun withCallToActionTextTypeface(callToActionTextTypeface: Typeface?): Builder {
            styles.callToActionTextTypeface = callToActionTextTypeface
            return this
        }

        @CanIgnoreReturnValue
        fun withCallToActionTextSize(callToActionTextSize: Float): Builder {
            styles.callToActionTextSize = callToActionTextSize
            return this
        }

        @CanIgnoreReturnValue
        fun withCallToActionTypefaceColor(callToActionTypefaceColor: Int): Builder {
            styles.callToActionTypefaceColor = callToActionTypefaceColor
            return this
        }

        @CanIgnoreReturnValue
        fun withCallToActionBackgroundColor(callToActionBackgroundColor: ColorDrawable?): Builder {
            styles.callToActionBackgroundColor = callToActionBackgroundColor
            return this
        }

        @CanIgnoreReturnValue
        fun withPrimaryTextTypeface(primaryTextTypeface: Typeface?): Builder {
            styles.primaryTextTypeface = primaryTextTypeface
            return this
        }

        @CanIgnoreReturnValue
        fun withPrimaryTextSize(primaryTextSize: Float): Builder {
            styles.primaryTextSize = primaryTextSize
            return this
        }

        @CanIgnoreReturnValue
        fun withPrimaryTextTypefaceColor(primaryTextTypefaceColor: Int): Builder {
            styles.primaryTextTypefaceColor = primaryTextTypefaceColor
            return this
        }

        @CanIgnoreReturnValue
        fun withPrimaryTextBackgroundColor(primaryTextBackgroundColor: ColorDrawable?): Builder {
            styles.primaryTextBackgroundColor = primaryTextBackgroundColor
            return this
        }

        @CanIgnoreReturnValue
        fun withSecondaryTextTypeface(secondaryTextTypeface: Typeface?): Builder {
            styles.secondaryTextTypeface = secondaryTextTypeface
            return this
        }

        @CanIgnoreReturnValue
        fun withSecondaryTextSize(secondaryTextSize: Float): Builder {
            styles.secondaryTextSize = secondaryTextSize
            return this
        }

        @CanIgnoreReturnValue
        fun withSecondaryTextTypefaceColor(secondaryTextTypefaceColor: Int): Builder {
            styles.secondaryTextTypefaceColor = secondaryTextTypefaceColor
            return this
        }

        @CanIgnoreReturnValue
        fun withSecondaryTextBackgroundColor(secondaryTextBackgroundColor: ColorDrawable?): Builder {
            styles.secondaryTextBackgroundColor = secondaryTextBackgroundColor
            return this
        }

        @CanIgnoreReturnValue
        fun withTertiaryTextTypeface(tertiaryTextTypeface: Typeface?): Builder {
            styles.tertiaryTextTypeface = tertiaryTextTypeface
            return this
        }

        @CanIgnoreReturnValue
        fun withTertiaryTextSize(tertiaryTextSize: Float): Builder {
            styles.tertiaryTextSize = tertiaryTextSize
            return this
        }

        @CanIgnoreReturnValue
        fun withTertiaryTextTypefaceColor(tertiaryTextTypefaceColor: Int): Builder {
            styles.tertiaryTextTypefaceColor = tertiaryTextTypefaceColor
            return this
        }

        @CanIgnoreReturnValue
        fun withTertiaryTextBackgroundColor(tertiaryTextBackgroundColor: ColorDrawable?): Builder {
            styles.tertiaryTextBackgroundColor = tertiaryTextBackgroundColor
            return this
        }

        @CanIgnoreReturnValue
        fun withMainBackgroundColor(mainBackgroundColor: ColorDrawable?): Builder {
            styles.mainBackgroundColor = mainBackgroundColor
            return this
        }

        fun build(): NativeTemplateStyle {
            return styles
        }
    }
}