package thrillio;

import entities.Bookmark;
import entities.User;
import managers.BookMarkManager;
import managers.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;


    public static void main(String[] args) {
        loadData();
        start();

    }

    private static void start() {
        // System.out.println("\n 2. Bookmarking ...");

        for (User user : users) {
            View.browse(user, bookmarks);
        }
    }

    private static void loadData() {
        System.out.println("\n 1. Loading data ...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookMarkManager.getInstance().getBookmarks();

        /*System.out.println("Printing data...");
        printUserData();
        printBookmarkData();*/
    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarks : bookmarks) {
            for (Bookmark bookmark : bookmarks) {
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
