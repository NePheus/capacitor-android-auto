package nepheus.capacitor.androidauto;

import androidx.annotation.NonNull;
import androidx.car.app.Screen;
import androidx.car.app.model.Template;
import androidx.car.app.CarContext;

public class AndroidAutoScreen extends Screen {
    public AndroidAutoScreen(@NonNull CarContext carContext) {
        super(carContext);
    }

    @NonNull
    @Override
    public Template onGetTemplate() {
        return AndroidAutoHelpers.GetTemplate(getCarContext().getApplicationContext());
    }
}
