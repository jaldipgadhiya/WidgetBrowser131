package com.android.acadgild.widgetbrowser131;

/*
Class extended from AppWidgetProvider
 */
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider {

    // On update method
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        // Loop through appWidgetIds to find currentWidgetId
        for(int i=0; i< appWidgetIds.length; i++)
        {
            int currentWidgetId = appWidgetIds[i];
            // URL declared to be parsed
            String url = "https://www.acadgild.com";
            String title = context.getResources().getString(R.string.app_browser_chooser);
            // ACTION_VIEW Implicit intent
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Intent chooser = Intent.createChooser(intent, title);
            //Set URL tpo intent
            intent.setData(Uri.parse(url));
            //Pending intent to get activity of intent
            PendingIntent pending = PendingIntent.getActivity(context,0,intent,0);
            //Remote view - view that we want to assign to widget
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.activity_main);
            //OnClickPendingIntent listener when clicked on icon it will call pending intent
            views.setOnClickPendingIntent(R.id.widget_img_launcher,pending);
            // Call updateAppWidget to update App Widget
            appWidgetManager.updateAppWidget(currentWidgetId,views);

        }
    }
}
