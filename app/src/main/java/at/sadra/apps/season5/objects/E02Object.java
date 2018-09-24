package at.sadra.apps.season5.objects;

public class E02Object {
     private int imageRecId;
     private String title;
     private String description;

    public E02Object() {
    }

    public E02Object(int imageRecId, String title, String description) {
        this.imageRecId = imageRecId;
        this.title = title;
        this.description = description;
    }

    public int getImageRecId() {
        return imageRecId;
    }

    public void setImageRecId(int imageRecId) {
        this.imageRecId = imageRecId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
