package com.example.compose_navigation.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class NewsAppWidgetReceiver: GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget = NewsAppWidget()

}