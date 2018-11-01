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
package splitties.viewdsl.core.styles

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.StyleRes
import android.util.AttributeSet
import android.view.View
import splitties.viewdsl.core.NO_THEME
import splitties.viewdsl.core.getThemeAttrStyledView
import splitties.viewdsl.core.viewFactory
import splitties.viewdsl.core.wrapCtxIfNeeded

typealias NewViewWithStyleAttrRef<V> = (Context, AttributeSet?, Int) -> V

inline operator fun <reified V : View> XmlStyle<V>.invoke(
        ctx: Context,
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: V.() -> Unit = {}
): V = ctx.viewFactory.getThemeAttrStyledView<V>(ctx.wrapCtxIfNeeded(theme), null, styleAttr).also {
    it.id = id
}.apply(initView)
