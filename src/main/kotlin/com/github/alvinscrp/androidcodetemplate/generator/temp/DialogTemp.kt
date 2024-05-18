package com.github.alvinscrp.androidcodetemplate.generator.temp

import com.github.alvinscrp.androidcodetemplate.generator.util.AppType
import com.github.alvinscrp.androidcodetemplate.generator.util.dialogLayoutName
import com.github.alvinscrp.androidcodetemplate.generator.util.firstUppercase
import com.github.alvinscrp.androidcodetemplate.generator.util.fragmentLayoutName


/**
 * 生成XxDialog文件的内容，你的项目里是啥，就是啥，不要用我这个模板
 */
fun dialogTemp(
    appType: AppType,
    modulePackageName: String,
    classPackageName: String,
    moduleName: String,
    bizName: String
): String {
    return """
    package $classPackageName
    
    import android.content.Context
    import ${appType.fullBaseDialog()}
    import ${modulePackageName}.R
    import androidx.databinding.DataBindingUtil
    import ${modulePackageName}.databinding.Dialog${firstUppercase(bizName)}Binding
    
    class ${firstUppercase(bizName)}Dialog(context: Context) : CustomDialog(context){
        private val binding = DataBindingUtil.inflate<Dialog${firstUppercase(bizName)}Binding>(
            layoutInflater, R.layout.${dialogLayoutName(moduleName, bizName)}, null, false
        )

        init {
            setView(binding.root)
            setDimAmount(0.7f)
            setupView()
        }
        
        private fun setupView() {

        }
    }
""".trimIndent()
}



