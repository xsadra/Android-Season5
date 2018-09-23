package at.sadra.apps.season5.objects;

public class E01Object {
    int drawable;
    String name;

    public E01Object(int drawable, String name) {
        this.drawable = drawable;
        this.name = name;
    }

    public E01Object() {
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
