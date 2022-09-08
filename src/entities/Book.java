package entities;

import constants.BookGenre;
import org.apache.commons.lang3.StringUtils;
import partner.Shareable;

import java.util.Arrays;
import java.util.StringJoiner;

public class Book extends Bookmark implements Shareable {
    private int publishedYear;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazonRaring;

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRaring() {
        return amazonRaring;
    }

    public void setAmazonRaring(double amazonRaring) {
        this.amazonRaring = amazonRaring;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publishedYear=" + publishedYear +
                ", publisher='" + publisher + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", genre='" + genre + '\'' +
                ", amazonRaring=" + amazonRaring +
                '}';
    }

    @Override
    public boolean isKidFriendly() {
        if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(",", "", "");
        Arrays.stream(authors).forEach(stringJoiner::add);
        builder.append("<item>");
        builder.append("<type>Book</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<authors>").append(stringJoiner).append("</authors>");
        builder.append("<publisher>").append(publisher).append("</publisher>");
        builder.append("<publicationYear>").append(publishedYear).append("</publicationYear>");
        builder.append("<genre>").append(genre).append("</genre>");
        builder.append("<amazonRaring>").append(amazonRaring).append("</amazonRaring>");
        builder.append("</item>");

        return builder.toString();
    }


}
