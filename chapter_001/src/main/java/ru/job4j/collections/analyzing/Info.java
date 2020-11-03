package ru.job4j.collections.analyzing;

public class Info {
    private int added = 0;
    private int changed = 0;
    private int deleted = 0;

    public int getAdded() {
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
