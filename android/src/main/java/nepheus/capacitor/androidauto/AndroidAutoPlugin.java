package nepheus.capacitor.androidauto;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "AndroidAuto")
public class AndroidAutoPlugin extends Plugin {

    private AndroidAuto implementation = new AndroidAuto();

    @PluginMethod
    public void setTemplate(PluginCall call) {
        try {
            implementation.setTemplate(getContext(), call.getObject("template"));
            call.resolve();
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }

    /**
     * Listen for our intent action
     *
     */
    @Override
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);

        if (intent.getAction().equals(getContext().getResources().getString(R.string.intent_filter_action_android_auto_action))) {
            JSObject ret = new JSObject();
            ret.put("data", intent.getStringExtra("data"));
            notifyListeners("action", ret, true);
        }
    }
}
