package srongklod_bangtamruat.plantseconomic.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class PostModel implements Parcelable {

    private String dataTimeString, postString;

    public PostModel() {
    }

    public PostModel(String dataTimeString, String postString) {
        this.dataTimeString = dataTimeString;
        this.postString = postString;
    }

    protected PostModel(Parcel in) {
        dataTimeString = in.readString();
        postString = in.readString();
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    public String getDataTimeString() {
        return dataTimeString;
    }

    public void setDataTimeString(String dataTimeString) {
        this.dataTimeString = dataTimeString;
    }

    public String getPostString() {
        return postString;
    }

    public void setPostString(String postString) {
        this.postString = postString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dataTimeString);
        dest.writeString(postString);
    }
}   // Main Class
