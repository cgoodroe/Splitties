/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("NOTHING_TO_INLINE")

package splitties.viewdsl.design

import android.support.design.widget.CollapsingToolbarLayout
import splitties.viewdsl.core.matchParent
import splitties.viewdsl.core.wrapContent
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams as LP

@Suppress("unused") val CollapsingToolbarLayout.pin get() = LP.COLLAPSE_MODE_PIN
@Suppress("unused") val CollapsingToolbarLayout.parallax get() = LP.COLLAPSE_MODE_PARALLAX

inline fun CollapsingToolbarLayout.defaultLParams(
        width: Int = matchParent,
        height: Int = wrapContent,
        collapseMode: Int = LP.COLLAPSE_MODE_OFF,
        parallaxMultiplier: Float = 0.5f // Default value as of 27.1.0
) = LP(width, height).also {
    it.collapseMode = collapseMode
    it.parallaxMultiplier = parallaxMultiplier
}

inline fun CollapsingToolbarLayout.defaultLParams(
        width: Int = matchParent,
        height: Int = wrapContent,
        initParams: LP.() -> Unit
) = LP(width, height).apply(initParams)

inline fun CollapsingToolbarLayout.defaultLParams(
        width: Int = matchParent,
        height: Int = wrapContent
) = LP(width, height)
