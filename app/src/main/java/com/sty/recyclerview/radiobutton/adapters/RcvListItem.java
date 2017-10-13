package com.sty.recyclerview.radiobutton.adapters;

/**
 * Created by Steven.T on 2017/10/12/0012.
 */

public class RcvListItem {
    private int name;
    private int icon;
    private boolean isChecked;

    public RcvListItem(int name, int icon, boolean isChecked) {
        this.name = name;
        this.icon = icon;
        this.isChecked = isChecked;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
