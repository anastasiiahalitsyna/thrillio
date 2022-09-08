package controllers;

import entities.Bookmark;
import entities.User;
import managers.BookMarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();

    private BookmarkController() {
    }

    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookMarkManager.getInstance().saveUserBookmark(user, bookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendStatus, Bookmark bookmark) {
        BookMarkManager.getInstance().setKidFriendlyStatus(user, kidFriendStatus, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookMarkManager.getInstance().share(user, bookmark);
    }
}
