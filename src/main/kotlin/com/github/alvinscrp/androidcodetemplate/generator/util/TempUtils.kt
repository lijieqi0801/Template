package com.github.alvinscrp.androidcodetemplate.generator.util

import com.android.tools.idea.wizard.template.camelCaseToUnderlines
import com.android.tools.idea.wizard.template.underscoreToCamelCase
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

fun activityLayoutName(moduleName: String, bizName: String): String {
    val name = bizName.map { if (it.isUpperCase()) "_${it.lowercaseChar()}" else it}.joinToString("")
    return "activity_$name"
}

fun fragmentLayoutName(moduleName: String, bizName: String): String {
    val name = bizName.map { if (it.isUpperCase()) "_${it.lowercaseChar()}" else it}.joinToString("")
    return "fragment_$name"
}

fun dialogLayoutName(moduleName: String, bizName: String): String {
    val name = bizName.map { if (it.isUpperCase()) "_${it.lowercaseChar()}" else it}.joinToString("")
    return "dialog_$name"
}


/**
 * 形式 ab_cd_ef 必须都是小写，以下划线连接
 */
fun layoutPrefix(moduleName: String, bizName: String): String {
    return "${moduleName.toLowerCaseAsciiOnly()}_${camelCaseToUnderlines(bizName).toLowerCaseAsciiOnly()}_template"
}

fun firstUppercase(param: String): String {
    return param.replaceFirstChar { it.uppercase() }
}
