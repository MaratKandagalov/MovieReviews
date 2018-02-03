
package ru.mkandagalov.moviereviews.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable
{

    @SerializedName("display_title")
    @Expose
    private String displayTitle;
    @SerializedName("mpaa_rating")
    @Expose
    private String mpaaRating;
    @SerializedName("critics_pick")
    @Expose
    private Integer criticsPick;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("headline")
    @Expose
    private String headline;
    @SerializedName("summary_short")
    @Expose
    private String summaryShort;
    @SerializedName("publication_date")
    @Expose
    private String publicationDate;
    @SerializedName("opening_date")
    @Expose
    private String openingDate;
    @SerializedName("date_updated")
    @Expose
    private String dateUpdated;
    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("multimedia")
    @Expose
    private Multimedia multimedia;
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;

    protected Result(Parcel in) {
        this.displayTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.mpaaRating = ((String) in.readValue((String.class.getClassLoader())));
        this.criticsPick = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.byline = ((String) in.readValue((String.class.getClassLoader())));
        this.headline = ((String) in.readValue((String.class.getClassLoader())));
        this.summaryShort = ((String) in.readValue((String.class.getClassLoader())));
        this.publicationDate = ((String) in.readValue((String.class.getClassLoader())));
        this.openingDate = ((String) in.readValue((String.class.getClassLoader())));
        this.dateUpdated = ((String) in.readValue((String.class.getClassLoader())));
        this.link = ((Link) in.readValue((Link.class.getClassLoader())));
        this.multimedia = ((Multimedia) in.readValue((Multimedia.class.getClassLoader())));
    }

    public Result() {
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Integer getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(Integer criticsPick) {
        this.criticsPick = criticsPick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(displayTitle);
        dest.writeValue(mpaaRating);
        dest.writeValue(criticsPick);
        dest.writeValue(byline);
        dest.writeValue(headline);
        dest.writeValue(summaryShort);
        dest.writeValue(publicationDate);
        dest.writeValue(openingDate);
        dest.writeValue(dateUpdated);
        dest.writeValue(link);
        dest.writeValue(multimedia);
    }

    public int describeContents() {
        return  0;
    }

}
