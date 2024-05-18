package com.github.alvinscrp.androidcodetemplate.generator.temp

import com.github.alvinscrp.androidcodetemplate.generator.util.AppType
import com.github.alvinscrp.androidcodetemplate.generator.util.firstUppercase


fun activityLayoutTemp(): String {
    return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:ignore="MissingDefaultResource">
    <data>

      
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/cl_board"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

       

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
}

fun fragmentLayoutTemp(appType: AppType,classPackageName: String, bizName: String): String {
    return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:ignore="MissingDefaultResource">
    <data>

      
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

       

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
}

fun itemFirstLayoutTemp(classPackageName: String, bizName: String): String {
    return """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:ignore="MissingDefaultResource">

    <data>

        <variable
            name="item"
            type="${classPackageName}.${bizName}.model.${firstUppercase(bizName)}FirstModel" />

        <variable
            name="listener"
            type="${classPackageName}.${bizName}.model.${firstUppercase(bizName)}FirstModel.OnItemEventListener" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout

        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="@{()->listener.on${firstUppercase(bizName)}FirstClick(item)}"
        android:orientation="vertical"
        android:padding="@dimen/pt_11">

        <TextView
            android:id="@+id/tvTitle"
            android:text="@{item.title}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@color/black"
            android:textSize="@dimen/pt_18"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:text="这是标题" />

        <TextView
            android:text="@{item.summary}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="@dimen/pt_3"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/tvTitle"
            tools:text="这是第二行内容" />
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>

"""
}