package com.github.alvinscrp.androidcodetemplate.generator.temp

import com.github.alvinscrp.androidcodetemplate.generator.util.AppType
import com.github.alvinscrp.androidcodetemplate.generator.util.firstUppercase
import com.github.alvinscrp.androidcodetemplate.generator.util.fragmentLayoutName


/**
 * 生成XxFragment文件的内容，你的项目里是啥，就是啥，不要用我这个模板
 */
fun fragmentTemp(
    appType: AppType,
    modulePackageName: String,
    classPackageName: String,
    moduleName: String,
    bizName: String
): String {
    return """
    package $classPackageName
    import android.os.Bundle
    import ${appType.fullBaseFragment()}
    import ${modulePackageName}.R
    import me.reezy.cosmo.binding.binding
    import ${modulePackageName}.databinding.Fragment${firstUppercase(bizName)}Binding
    
    class ${firstUppercase(bizName)}Fragment : ${appType.simpleBaseFragment()}(R.layout.${fragmentLayoutName(moduleName, bizName)}) {
        companion object{
            fun newInstance(): ${firstUppercase(bizName)}Fragment{
                val args = Bundle()
                val fragment = ${firstUppercase(bizName)}Fragment()
                fragment.arguments = args
                return fragment
            }
        }
        private val binding:Fragment${firstUppercase(bizName)}Binding> by binding()
        
        override fun onSetupUI() {
           
        }
    }
""".trimIndent()
}



