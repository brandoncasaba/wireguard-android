/*
 * Copyright © 2020 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.util

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import com.wireguard.android.activity.SettingsActivity
import kotlinx.coroutines.CoroutineScope

fun Context.resolveAttribute(@AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.data
}

fun Fragment.requireTargetFragment(): Fragment {
    return requireNotNull(targetFragment) { "A target fragment should always be set for $this" }
}

val Preference.activity: SettingsActivity
    get() = if (this.context is SettingsActivity) this.context as SettingsActivity else throw IllegalStateException("Failed to resolve SettingsActivity")

val Preference.lifecycleScope: CoroutineScope
    get() = this.activity.lifecycleScope
