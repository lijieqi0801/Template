package com.github.alvinscrp.androidcodetemplate.generator


import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.alvinscrp.androidcodetemplate.generator.util.AppType


class PluginGeneratorProvider : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        //这里建了三套模板
        generator(AppType.BLOCKS, GeneratorType.Activity),
        generator(AppType.BLOCKS, GeneratorType.Fragment),
        generator(AppType.BLOCKS, GeneratorType.Dialog),
    )
}