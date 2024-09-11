package com.example.compose_navigation.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_navigation.components.NewsWidgetContent
import com.example.compose_navigation.viewmodel.NewsViewModel

class NewsAppWidget: GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        provideContent {
          NewsWidgetContent(
              modifier = GlanceModifier,
              viewModel = NewsViewModel()
          )
        }
    }

}