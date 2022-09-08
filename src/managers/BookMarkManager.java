package managers;

import dao.BookmarkDao;
import entities.*;

public class BookMarkManager {
    private static BookMarkManager instance = new BookMarkManager();
    private static BookmarkDao dao = new BookmarkDao();

    private BookMarkManager() {
    }

    //singleton design pattern
    public static BookMarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long id,
                             String title,
                             String profileUrl,
                             int releaseYear,
                             String[] cats,
                             String[] directors,
                             String genre,
                             double imbRating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setYearRealise(releaseYear);
        movie.setCats(cats);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImbRaring(imbRating);
        return movie;
    }

    public Book createBook(long id,
                           String title,
                           int publishedYear,
                           String publisher,
                           String[] authors,
                           String genre,
                           double amazonRaring) {

        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublishedYear(publishedYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRaring(amazonRaring);

        return book;
    }

    public WebLink createWebLink(long id,
                                 String title,
                                 String url,
                                 String host) {
        WebLink webLink = new WebLink();
        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);

        return webLink;
    }

    public Bookmark[][] getBookmarks() {
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {

        UserBookmark userBookmark = new UserBookmark();

        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        dao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid friendly status : " + kidFriendStatus + ",  Marked by:   " + user.getEmail() + ", " + bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBY(user);
        System.out.println("Data to be shared:  ");
        if (bookmark instanceof Book) {
            System.out.println(((Book) bookmark).getItemData());
        } else if(bookmark instanceof WebLink){
            System.out.println(((WebLink) bookmark).getItemData());
        }
    }
}
