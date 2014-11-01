package com.coiniverse.enumerations;

/**
 * Created by john on 8/5/14.
 */
public enum AccountStatusEnum {
    ACCOUNT_STATUS_ACTIVE("active"),
            ACCOUNT_STATUS_GROUPED("grouped"),
            ACCOUNT_STATUS_GROUPABLE("groupable"),
            ACCOUNT_STATUS_COMPLETE("complete"),
            ACCOUNT_STATUS_CONFIRMED("confirmed"),
            ACCOUNT_STATUS_UNCONFIRMED("unconfirmed");

    private String mValue;

    AccountStatusEnum(String value) {
        this.mValue = value;
    }

    public static AccountStatusEnum getFromText(String text) {
        for(AccountStatusEnum accountStatus : AccountStatusEnum.values()) {
            if(accountStatus.mValue.equals(text)) {
                return accountStatus;
            }
        }
        return null;
    }

}
