package com.wannar.wannar_adroid2.util.kotlin_extentions

import luyunfeng.strawberryclock.utils.ListUtil

/**
 * Created by luyunfeng on 17/8/17.
 */

fun List<*>?.isInvalid(): Boolean = ListUtil.isEmpty(this)

fun List<*>?.isValid() = !isInvalid()

fun Map<*, *>?.isInvalid(): Boolean = ListUtil.isEmpty(this)

fun Map<*, *>?.isValid() = !isInvalid()
