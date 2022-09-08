package entities;

import managers.BookMarkManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class WebLinkTest {
    @Test
    public void testIsKIdFriendlyEligible() {
        WebLink webLink = BookMarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/porn-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        boolean isKidFriendlyEligible = webLink.isKidFriendly();
        assertFalse("For porn in url - isKidFriendlyEligible must return false", isKidFriendlyEligible);


        webLink = BookMarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2", "http://www.javaworld.com/article/2072759/java-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertFalse("For porn in title - isKidFriendlyEligible must return false", isKidFriendlyEligible);

        webLink = BookMarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/java-java/taming-tiger--part-2.html", "http://www.adult.com");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertFalse("For adult in host - isKidFriendlyEligible must return false", isKidFriendlyEligible);


        webLink = BookMarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/adult-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertTrue("For adult in url, but not in the host part - isKidFriendlyEligible must return true", isKidFriendlyEligible);

        webLink = BookMarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2", "http://www.javaworld.com/article/2072759/java-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        isKidFriendlyEligible = webLink.isKidFriendly();
        assertTrue("For adult in title - isKidFriendlyEligible must return true", isKidFriendlyEligible);


    }
}