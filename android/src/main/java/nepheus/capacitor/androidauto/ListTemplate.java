package nepheus.capacitor.androidauto;

import java.util.ArrayList;

public class ListTemplate {
    private final String title;

    private final ArrayList<ListItem> items;

    public ListTemplate(String title, ArrayList<ListItem> items) {
        this.title = title;
        this.items = items;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<ListItem> getItems() {
        return this.items;
    }
}