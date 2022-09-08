package thrillio;

import constants.BookGenre;
import constants.Gender;
import constants.MovieGenre;
import constants.UserType;
import entities.Bookmark;
import entities.User;
import entities.UserBookmark;
import managers.BookMarkManager;
import managers.UserManager;

public class DataStore {
    public static final int TOTAL_USER_COUNT = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int USER_BOOKMARK_LIMIT = 5;

    public static User[] getUsers() {
        return users;
    }

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    private static User[] users = new User[TOTAL_USER_COUNT];

    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];

    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];

    private static int bookmarkIndex;


    public static void loadData() {
        loadUser();
        loadWebLinks();
        loadMovies();
        loadBooks();
    }

    public static void loadBooks() {
        BookMarkManager bookMarkManager = BookMarkManager.getInstance();
        bookmarks[2][0] = bookMarkManager.createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = bookMarkManager.createBook(4001, "Self-Reliance and Other Essays", 1993, "Dover Publications", new String[]{"Ralph Waldo Emerso	"}, BookGenre.PHILOSOPHY, 4.5);
        bookmarks[2][2] = bookMarkManager.createBook(4002, "Light From Many Lamps", 1988, "Touchstone", new String[]{"Lillian Eichler Watson"}, BookGenre.PHILOSOPHY, 5.0);
        bookmarks[2][3] = bookMarkManager.createBook(4003, "Head First Design Patterns", 2004, "O'Reilly Media", new String[]{"Eric Freeman,Bert Bates,Kathy Sierra,Elisabeth Robson"}, BookGenre.TECHNICAL, 4.5);
        bookmarks[2][4] = bookMarkManager.createBook(4004, "Effective Java Programming Language Guide", 2007, "Prentice Hall", new String[]{"Joshua Bloch"}, BookGenre.TECHNICAL, 4.9);

    }

    public static void loadMovies() {
        BookMarkManager bookMarkManager = BookMarkManager.getInstance();

        bookmarks[1][0] = bookMarkManager.createMovie(3000, "Citizen Kane", "", 1941, new String[]{"Orson Welles, Joseph Cotten"}, new String[]{"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
        bookmarks[1][1] = bookMarkManager.createMovie(3001, "The Grapes of Wrath", "", 1948, new String[]{"	Henry Fonda,Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 8.2);
        bookmarks[1][2] = bookMarkManager.createMovie(3002, "A Touch of Greatnesse", "", 2004, new String[]{"Albert Cullum"}, new String[]{"Leslie Sullivan	Documentaries"}, MovieGenre.DOCUMENTARIES, 7.3);
        bookmarks[1][3] = bookMarkManager.createMovie(3003, "The Big Bang Theory", "", 2001, new String[]{"Kaley Cuoco,Jim Parsons"}, new String[]{"Chuck Lorre,Bill Prady"}, MovieGenre.TV_SHOWS, 8.7);
        bookmarks[1][4] = bookMarkManager.createMovie(3004, "Ikiru", "", 1952, new String[]{"Takashi Shimura,Minoru Chiaki"}, new String[]{"Akira Kurosawa"}, MovieGenre.FOREIGN_MOVIES, 8.4);
    }

    public static void loadWebLinks() {
        BookMarkManager bookMarkManager = BookMarkManager.getInstance();
        bookmarks[0][0] = bookMarkManager.createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        bookmarks[0][1] = bookMarkManager.createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com");
        bookmarks[0][2] = bookMarkManager.createWebLink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");
        bookmarks[0][3] = bookMarkManager.createWebLink(2003, "NIO tutorial by Greg Travis", "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");
        bookmarks[0][4] = bookMarkManager.createWebLink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");
    }

    public static void loadUser() {
        UserManager userManager = UserManager.getInstance();
        users[0] = userManager.createUser(1000, "user0@semanticsquare.com", "test", "John", "M", Gender.MALE, UserType.USER);
        users[1] = userManager.createUser(1001, "user1@semanticsquare.com", "test", "Sam", "M", Gender.MALE, UserType.USER);
        users[2] = userManager.createUser(1002, "user2@semanticsquare.com", "test", "Anita", "M", Gender.FEMALE, UserType.EDITOR);
        users[3] = userManager.createUser(1003, "user3@semanticsquare.com", "test", "Sara", "M", Gender.FEMALE, UserType.EDITOR);
        users[4] = userManager.createUser(1004, "user4@semanticsquare.com", "test", "Dheeru", "M", Gender.MALE, UserType.CHIEF_EDITOR);
    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;
    }
}
