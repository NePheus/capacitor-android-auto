package nepheus.capacitor.androidauto;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.car.app.Session;
import androidx.car.app.Screen;

public class AndroidAutoSession extends Session {
    @NonNull
    @Override
    public Screen onCreateScreen(@NonNull Intent intent) {
        return new AndroidAutoScreen(getCarContext());
    }
}
