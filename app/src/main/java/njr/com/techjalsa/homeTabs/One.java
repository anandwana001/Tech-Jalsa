package njr.com.techjalsa.homeTabs;

/**
 * Created by dell on 21-02-2017.
 */

public class One {

    private int mImageResource;
    private String mEventName;
    private String mEventTime;
    private String mEventVenue;

    public One() {
    }

    public One(int mImageResource, String mEventName, String mEventTime,String mEventVenue) {
        this.mImageResource = mImageResource;
        this.mEventName = mEventName;
        this.mEventTime = mEventTime;
        this.mEventVenue = mEventVenue;
    }

    public int getmImageView() {
        return this.mImageResource;
    }

    public String getmEventName() {
        return this.mEventName;
    }

    public String getmEventTime() {
        return this.mEventTime;
    }

    public String getmEventVenue() {
        return this.mEventVenue;
    }
}
