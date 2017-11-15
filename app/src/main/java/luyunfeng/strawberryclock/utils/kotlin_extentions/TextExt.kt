package com.wannar.wannar_adroid2.util.kotlin_extentions

import com.wannar.base_library.text.StringUtils

/**
 * Created by luyunfeng on 17/8/16.
 */

fun String?.isInvalid(): Boolean = StringUtils.isEmpty(this)

fun String?.isValid() = !isInvalid()

