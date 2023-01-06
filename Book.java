package FMA_7AGA;
public class Book implements Comparable<Book> {
    private int id;
    private String author;
    private String title;
    private String genre;
    private double price;
    private String publishDate;
    private String description;

    public Book(){
        id=0;
        author=null;
        title=null;
        genre=null;
        price=0.0;
        publishDate=null;
        description=null;
    }
    
     public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

   public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Book o) {
        return (id-o.id);
    } 
    
}
