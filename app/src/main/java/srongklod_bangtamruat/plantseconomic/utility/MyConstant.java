package srongklod_bangtamruat.plantseconomic.utility;

import srongklod_bangtamruat.plantseconomic.R;

/**
 * Created by masterung on 30/12/2017 AD.
 */

public class MyConstant {

    private int[] iconCustomerInts = new int[]{
            R.drawable.icon_custom1,
            R.drawable.icon_custom2,
            R.drawable.icon_custom3,
            R.drawable.icon_custom4,
            R.drawable.icon_custom5,
            R.drawable.icon_custom6};

    private int[] iconSupplierInts = new int[]{
            R.drawable.icon_custom1,
            R.drawable.icon_custom2,
            R.drawable.icon_custom3,
            R.drawable.icon_custom4};

    private int[] iconTransportInts = new int[]{
            R.drawable.icon_custom1,
            R.drawable.icon_custom2,
            R.drawable.icon_custom3,
            R.drawable.icon_custom4};

    private String[] titleCustomerStrings = new String[]{
            "Home",
            "Add Friend",
            "Message",
            "News",
            "Shop",
            "Chat"};

    private String[] titleSupplierStrings = new String[]{
            "Home",
            "Message",
            "News",
            "Shop"};

    private String[] titleTransportStrings = new String[]{
            "Home",
            "Message",
            "Package",
            "Logistic"};


    private String[] fieldCustomerStrings = new String[]{
            "lastNameString",
            "nameString",
            "phoneString",
            "uidUserString",
            "avataString"};

    private String[] fieldSupplierStrings = new String[]{
            "addressString",
            "bussinessString",
            "companyString",
            "faxString",
            "headquartersString",
            "telephoneString",
            "uidUserString",
            "statusString"};

    private String[] fieldTransportStrings = new String[]{
            "addressString",
            "branchString",
            "companyString",
            "faxString",
            "headquarterString",
            "telephoneString",
            "uidUserString",
            "statusString"};


    public int[] getIconTransportInts() {
        return iconTransportInts;
    }

    public String[] getTitleTransportStrings() {
        return titleTransportStrings;
    }

    public int[] getIconSupplierInts() {
        return iconSupplierInts;
    }

    public String[] getTitleSupplierStrings() {
        return titleSupplierStrings;
    }

    public int[] getIconCustomerInts() {
        return iconCustomerInts;
    }

    public String[] getTitleCustomerStrings() {
        return titleCustomerStrings;
    }

    public String[] getFieldCustomerStrings() {
        return fieldCustomerStrings;
    }

    public String[] getFieldSupplierStrings() {
        return fieldSupplierStrings;
    }

    public String[] getFieldTransportStrings() {
        return fieldTransportStrings;
    }
}
