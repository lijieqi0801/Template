package com.github.alvinscrp.androidcodetemplate.generator.util

enum class AppType(val key: String) {
    BLOCKS("fxj"), HYK("hyk"), MC("micai");


    fun fullBaseActivity(): String {
        return when (this) {
            BLOCKS -> "me.reezy.cosmo.base.BaseActivity"
            HYK -> "cn.com.haoyiku.base.HYKBaseActivity"
            MC -> "com.income.common.base.CBaseActivity"
        }
    }

    fun simpleBaseActivity(): String {
        return when (this) {
            BLOCKS, MC -> "BaseActivity"
            HYK -> "HYKBaseActivity"
        }
    }

    fun fullBaseFragment(): String {
        return when (this) {
            BLOCKS -> "me.reezy.cosmo.base.BaseFragment"
            HYK -> "cn.com.haoyiku.base.HYKBaseFragment"
            MC -> "com.income.common.base.CBaseFragment"
        }
    }

    fun simpleBaseFragment(): String {
        return when (this) {
            BLOCKS, MC -> "BaseFragment"
            HYK -> "HYKBaseFragment"
        }
    }
    fun simpleDialog(): String {
        return when (this) {
            BLOCKS, MC -> "CustomDialog"
            HYK -> "BottomDialog"
        }
    }

    fun fullBaseDialog(): String {
        return when (this) {
            BLOCKS,MC -> "me.reezy.cosmo.dialog.CustomDialog"
            HYK -> "me.reezy.cosmo.dialog.BottomDialog"
        }
    }
}