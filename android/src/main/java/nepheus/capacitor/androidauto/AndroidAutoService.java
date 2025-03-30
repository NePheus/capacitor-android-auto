package nepheus.capacitor.androidauto;

import androidx.annotation.NonNull;
import androidx.car.app.CarAppService;
import androidx.car.app.Session;
import androidx.car.app.validation.HostValidator;

public class AndroidAutoService extends CarAppService {
    @NonNull
    @Override
    public Session onCreateSession() {
        return new AndroidAutoSession();
    }

    @NonNull
    @Override
    public HostValidator createHostValidator() {
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR; 
    }
}
