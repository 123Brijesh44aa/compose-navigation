package com.example.compose_navigation.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.text.Text
import com.example.compose_navigation.text

class NewsAppWidget: GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
            Text(
                text = "News App Widget"
            )
        }
    }

}