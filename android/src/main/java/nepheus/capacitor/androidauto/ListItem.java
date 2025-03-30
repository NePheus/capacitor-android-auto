package nepheus.capacitor.androidauto;

public class ListItem {
    private final String title;

    private final Object actionPayload;

    public ListItem(String actionPayload, String title) {
        this.title = title;
        this.actionPayload = actionPayload;
    }

    public String getTitle() {
        return this.title;
    }

    public Object getActionPayload() {
        return this.actionPayload;
    }
}