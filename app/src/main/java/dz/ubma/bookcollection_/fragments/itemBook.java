package dz.ubma.bookcollection_.fragments;

public class itemBook {
    String title;
    String year;
    String iconBook;
    int iconStar;
    String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIconBook() {
        return iconBook;
    }

    public void setIconBook(String iconBook) {
        this.iconBook = iconBook;
    }

    public int getIconStar() {
        return iconStar;
    }

    public void setIconStar(int iconStar) {
        this.iconStar = iconStar;
    }

    public String getId() {
        return id;
    }

    public itemBook(){}

    public itemBook(String title, String year, String iconBook, int iconStar, String id) {
        this.title = title;
        this.year = year;
        this.iconBook = iconBook;
        this.iconStar = iconStar;
        this.id = id;
    }
}
