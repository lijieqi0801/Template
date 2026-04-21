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
    import me.reezy.cosmo.utility.window.fitsStatusBar
    import me.reezy.cosmo.utility.window.isStatusBarLight
    import ${modulePackageName}.databinding.${firstUppercase(moduleName)}Activity${firstUppercase(bizName)}Binding
    
    @Route("")
    class ${firstUppercase(bizName)}Activity : ${appType.simpleBaseActivity()}(R.layout.${activityLayoutName(moduleName, bizName)}) {
    
        private val binding:${firstUppercase(moduleName)}Activity${firstUppercase(bizName)}Binding by binding() 
        
        override fun onSetupUI() {
            window.setLayoutInStatusBar()
            window.isStatusBarLight = true
            window.navigationBarColor = (0xffF7F7F7).toInt()
            binding.toolbar.fitsStatusBar()
            setupClick()
        }
        
        private fun setupClick() {
        
        }
    }
""".trimIndent()
}



