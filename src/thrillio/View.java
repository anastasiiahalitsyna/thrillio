package thrillio;

import constants.KidFriendlyStatus;
import constants.UserType;
import controllers.BookmarkController;
import entities.Bookmark;
import entities.User;
import partner.Shareable;


public class View {
    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is browsing items...");
        int bookmarkCount = 0;

        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if (isBookmarked) {
                        bookmarkCount++;

                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);

                        System.out.println("New item Bookmarked --- " + bookmark);

                    }
                }
                if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
                    if (bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                        String kidFriendStatus = getKidFriendlyStatusDecision(bookmark);

                        if (!kidFriendStatus.equals(KidFriendlyStatus.UNKNOWN)) {
                            BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendStatus, bookmark);

                        }
                    }

                    if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                            && bookmark instanceof Shareable) {
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user,bookmark);
                        }

                    }

                }
            }


        }
    }

    private static boolean getShareDecision() {
        return Math.random() < 0.5;
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        double randomVal = Math.random();
        return randomVal < 0.4 ? KidFriendlyStatus.APPROVED : (randomVal >= 0.4 && randomVal < 0.8) ?
                KidFriendlyStatus.REJECTED : KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5;
    }




   /* public static void bookmark(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is bookmarking");

        for (int n = 0; n < DataStore.USER_BOOKMARK_LIMIT; n++) {

            int typeOffSet = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffSEt = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

            Bookmark bookmark = bookmarks[typeOffSet][bookmarkOffSEt];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);

            System.out.println(bookmark);
        }

    }*/


}
