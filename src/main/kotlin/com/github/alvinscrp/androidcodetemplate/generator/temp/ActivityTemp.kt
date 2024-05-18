package com.github.alvinscrp.androidcodetemplate.generator.temp

import com.github.alvinscrp.androidcodetemplate.generator.util.AppType
import com.github.alvinscrp.androidcodetemplate.generator.util.activityLayoutName
import com.github.alvinscrp.androidcodetemplate.generator.util.firstUppercase


/**
 * 生成XxActivity文件的内容，你的项目里是啥，就是啥，不要用我这个模板
 */
fun activityTemp(
    appType: AppType,
    modulePackageName: String,
    classPackageName: String,
    moduleName: String,
    bizName: String
): String {
    return """
    package $classPackageName

    import ${appType.fullBaseActivity()}
    import ${modulePackageName}.R
    import me.reezy.cosmo.binding.binding
    import me.reezy.cosmo.router.annotation.Route
    import me.reezy.cosmo.systembars.statusBar
    import android.graphics.Color
    import ${modulePackageName}.databinding.Activity${firstUppercase(bizName)}Binding
    
    @Route("")
    class ${firstUppercase(bizName)}Activity : ${appType.simpleBaseActivity()}(R.layout.${activityLayoutName(moduleName, bizName)}) {
    
        private val binding=binding<Activity${firstUppercase(bizName)}Binding>() 
        
        override fun onSetupUI() {
           statusBar().overlay().color(Color.TRANSPARENT)
        }
    }
""".trimIndent()
}



