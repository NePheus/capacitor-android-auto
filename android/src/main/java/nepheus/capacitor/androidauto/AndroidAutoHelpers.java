package nepheus.capacitor.androidauto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.car.app.model.ItemList;
import androidx.car.app.model.ListTemplate;
import androidx.car.app.model.Row;
import androidx.car.app.model.Template;

import com.getcapacitor.JSObject;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AndroidAutoHelpers {
    private static final String FILE_NAME = "android_auto_template.json";

    public static boolean SetTemplate(Context context, JSObject templateJson) {
        File file = new File(context.getFilesDir(), FILE_NAME);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(templateJson.toString());
            return true;
        } catch (Exception e) { }
        return false;
    }

    public static Template GetTemplate(Context context) {
        var templateJson = _readTemplateJson(context);
        return _parseListTemplate(context, templateJson);
    }

    private static JSObject _readTemplateJson(Context context) {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                return new JSObject(new BufferedReader(reader).readLine());
            } catch (Exception e) { }
        }
        return null;
    }

    private static ListTemplate _parseListTemplate(Context context, JSObject templateObj) {
        ItemList.Builder listBuilder = new ItemList.Builder();

        try {
            JSONArray items = templateObj.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                JSObject item = JSObject.fromJSONObject(items.getJSONObject(i));
                listBuilder.addItem(
                        new Row.Builder()
                                .setTitle(item.getString("title"))
                                .setOnClickListener(() -> {
                                    _startIntent(context, item.getString("actionPayload"));
                                })
                                .build()
                );
            }
        } catch (JSONException e) {
            return null;
        }

        return new ListTemplate.Builder()
                .setTitle(templateObj.getString("title"))
                .setSingleList(listBuilder.build())
                .build();
    }

    private static void _startIntent(Context context, String payload) {
        Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(context.getPackageName())
                .setPackage(null)
                .setAction(context.getResources().getString(R.string.intent_filter_action_android_auto_action))
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.replaceExtras(new Bundle());
        intent.putExtra("data", payload);
        context.startActivity(intent);
    }
}
