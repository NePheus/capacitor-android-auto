package nepheus.capacitor.androidauto;

import android.content.Context;

import com.getcapacitor.JSObject;

import org.json.JSONException;

public class AndroidAuto {

    public void setTemplate(Context context, JSObject templateObj) throws JSONException {
        if ("List".equals(templateObj.getString("type"))) {
            AndroidAutoHelpers.SetTemplate(context, templateObj);
        } else {
            throw new IllegalArgumentException("Invalid template");
        }
    }
}
