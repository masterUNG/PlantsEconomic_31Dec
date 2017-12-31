package srongklod_bangtamruat.plantseconomic.utility;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 27/12/2560.
 */

public class TransportModel implements Parcelable{

    private String uidUserString,companyString,
    addressString,faxString,telephoneString,branchString,headquarterString;

    public TransportModel() {
    }

    public TransportModel(String uidUserString,
                          String companyString,
                          String addressString,
                          String faxString,
                          String telephoneString,
                          String branchString,
                          String headquarterString) {
        this.uidUserString = uidUserString;
        this.companyString = companyString;
        this.addressString = addressString;
        this.faxString = faxString;
        this.telephoneString = telephoneString;
        this.branchString = branchString;
        this.headquarterString = headquarterString;
    }

    protected TransportModel(Parcel in) {
        uidUserString = in.readString();
        companyString = in.readString();
        addressString = in.readString();
        faxString = in.readString();
        telephoneString = in.readString();
        branchString = in.readString();
        headquarterString = in.readString();
    }

    public static final Creator<TransportModel> CREATOR = new Creator<TransportModel>() {
        @Override
        public TransportModel createFromParcel(Parcel in) {
            return new TransportModel(in);
        }

        @Override
        public TransportModel[] newArray(int size) {
            return new TransportModel[size];
        }
    };

    public String getUidUserString() {
        return uidUserString;
    }

    public void setUidUserString(String uidUserString) {
        this.uidUserString = uidUserString;
    }

    public String getCompanyString() {
        return companyString;
    }

    public void setCompanyString(String companyString) {
        this.companyString = companyString;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getFaxString() {
        return faxString;
    }

    public void setFaxString(String faxString) {
        this.faxString = faxString;
    }

    public String getTelephoneString() {
        return telephoneString;
    }

    public void setTelephoneString(String telephoneString) {
        this.telephoneString = telephoneString;
    }

    public String getBranchString() {
        return branchString;
    }

    public void setBranchString(String branchString) {
        this.branchString = branchString;
    }

    public String getHeadquarterString() {
        return headquarterString;
    }

    public void setHeadquarterString(String headquarterString) {
        this.headquarterString = headquarterString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uidUserString);
        parcel.writeString(companyString);
        parcel.writeString(addressString);
        parcel.writeString(faxString);
        parcel.writeString(telephoneString);
        parcel.writeString(branchString);
        parcel.writeString(headquarterString);
    }
}//Main Call
