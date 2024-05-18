package com.github.alvinscrp.androidcodetemplate.generator


import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.alvinscrp.androidcodetemplate.generator.util.activityLayoutName
import com.github.alvinscrp.androidcodetemplate.generator.temp.activityLayoutTemp
import com.github.alvinscrp.androidcodetemplate.generator.temp.activityTemp
import com.github.alvinscrp.androidcodetemplate.generator.temp.dialogTemp
import com.github.alvinscrp.androidcodetemplate.generator.temp.fragmentLayoutTemp
import com.github.alvinscrp.androidcodetemplate.generator.temp.fragmentTemp
import com.github.alvinscrp.androidcodetemplate.generator.util.AppType
import com.github.alvinscrp.androidcodetemplate.generator.util.dialogLayoutName
import com.github.alvinscrp.androidcodetemplate.generator.util.firstUppercase
import com.github.alvinscrp.androidcodetemplate.generator.util.fragmentLayoutName
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly

/**
 * 模板代码文件的创建与保存
 *
 * 这里有几个变量需要注意下：
 * ```
 * //当前批量生成类文件所在目录 com.example.x.y
 * classPackageName：
 *
 * //模块名，例如 user
 * val moduleName = moduleData.rootDir.name.toLowerCaseAsciiOnly()
 *
 * //模块包名，例如com.example.user , 在模块AndroidManifest.xml中配置的那个，一定要注意
 * val modulePackageName = projectData.applicationPackage
 * ```
 */
fun RecipeExecutor.activityRecipe(
    moduleData: ModuleTemplateData,
    bizName: String,
    classPackageName: String,
    appType: AppType
) {
    val (projectData, srcOut, resOut) = moduleData
    val moduleName = moduleData.rootDir.name.toLowerCaseAsciiOnly()
    val modulePackageName = projectData.applicationPackage ?: ""

    println("---->${projectData.rootDir},${projectData.applicationPackage},${moduleData.rootDir.name},${moduleData.packageName}")

    save(
        activityTemp(appType, modulePackageName, classPackageName, moduleName, bizName),
        srcOut.resolve("${firstUppercase(bizName)}Activity.kt")
    )
//    val activityClass = "${bizName.capitalize()}Activity"
//    val packageName = "${moduleData.packageName}.$modulePackageName"
//    val manifestOut = File(moduleData.manifestDir, "AndroidManifest.xml")
//    //插入Manifest，这个代码运行报错，反正我也用不到，就不管了
//    generateManifest(
//        moduleData = moduleData,
//        activityClass = "${firstUppercase(bizName)}Activity",
//        packageName = ".${modulePackageName}",
//        isLauncher = false,
//        hasNoActionBar = false,
//        isNewModule = false,
//        isLibrary = false,
//        generateActivityTitle = false,
//        manifestOut = manifestOut
//    )

    save(
        activityLayoutTemp(),
        resOut.resolve("layout/${activityLayoutName(moduleName, bizName)}.xml")
    )

}

fun RecipeExecutor.fragmentRecipe(
    moduleData: ModuleTemplateData,
    bizName: String,
    classPackageName: String,
    appType: AppType
) {
    val (projectData, srcOut, resOut) = moduleData
    val moduleName = moduleData.rootDir.name.toLowerCaseAsciiOnly()
    val modulePackageName = projectData.applicationPackage ?: ""

    println("---->${projectData.rootDir},${projectData.applicationPackage},${moduleData.rootDir.name},${moduleData.packageName}")

    save(
        fragmentTemp(appType, modulePackageName, classPackageName, moduleName, bizName),
        srcOut.resolve("${firstUppercase(bizName)}Fragment.kt")
    )
    save(
        fragmentLayoutTemp(appType, classPackageName, bizName),
        resOut.resolve("layout/${fragmentLayoutName(moduleName, bizName)}.xml")
    )
}

fun RecipeExecutor.dialogRecipe(
    moduleData: ModuleTemplateData,
    bizName: String,
    classPackageName: String,
    appType: AppType
) {
    val (projectData, srcOut, resOut) = moduleData
    val moduleName = moduleData.rootDir.name.toLowerCaseAsciiOnly()
    val modulePackageName = projectData.applicationPackage ?: ""
    println("---->${projectData.rootDir},${projectData.applicationPackage},${moduleData.rootDir.name},${moduleData.packageName}")

    save(
        dialogTemp(appType, modulePackageName, classPackageName, moduleName, bizName),
        srcOut.resolve("${firstUppercase(bizName)}Dialog.kt")
    )
    save(
        fragmentLayoutTemp(appType, classPackageName, bizName),
        resOut.resolve("layout/${dialogLayoutName(moduleName, bizName)}.xml")
    )
}