package srongklod_bangtamruat.plantseconomic.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class ShopModel implements Parcelable{

    private String nameProduceString, categoryString, descreptionString,
            priceString, stockString, urlImagePathString;

    public ShopModel() {
    }

    public ShopModel(String nameProduceString,
                     String categoryString,
                     String descreptionString,
                     String priceString,
                     String stockString,
                     String urlImagePathString) {
        this.nameProduceString = nameProduceString;
        this.categoryString = categoryString;
        this.descreptionString = descreptionString;
        this.priceString = priceString;
        this.stockString = stockString;
        this.urlImagePathString = urlImagePathString;
    }

    protected ShopModel(Parcel in) {
        nameProduceString = in.readString();
        categoryString = in.readString();
        descreptionString = in.readString();
        priceString = in.readString();
        stockString = in.readString();
        urlImagePathString = in.readString();
    }

    public static final Creator<ShopModel> CREATOR = new Creator<ShopModel>() {
        @Override
        public ShopModel createFromParcel(Parcel in) {
            return new ShopModel(in);
        }

        @Override
        public ShopModel[] newArray(int size) {
            return new ShopModel[size];
        }
    };

    public String getNameProduceString() {
        return nameProduceString;
    }

    public void setNameProduceString(String nameProduceString) {
        this.nameProduceString = nameProduceString;
    }

    public String getCategoryString() {
        return categoryString;
    }

    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }

    public String getDescreptionString() {
        return descreptionString;
    }

    public void setDescreptionString(String descreptionString) {
        this.descreptionString = descreptionString;
    }

    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    public String getStockString() {
        return stockString;
    }

    public void setStockString(String stockString) {
        this.stockString = stockString;
    }

    public String getUrlImagePathString() {
        return urlImagePathString;
    }

    public void setUrlImagePathString(String urlImagePathString) {
        this.urlImagePathString = urlImagePathString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameProduceString);
        dest.writeString(categoryString);
        dest.writeString(descreptionString);
        dest.writeString(priceString);
        dest.writeString(stockString);
        dest.writeString(urlImagePathString);
    }
}   // Main Class
