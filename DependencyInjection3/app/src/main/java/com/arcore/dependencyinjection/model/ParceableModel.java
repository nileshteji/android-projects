package com.arcore.dependencyinjection.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ParceableModel implements Parcelable {


    String name;
    String rollNumber;

    public ParceableModel(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public static Creator<ParceableModel> getCREATOR() {
        return CREATOR;
    }

    protected ParceableModel(Parcel in) {
    }

    public static final Creator<ParceableModel> CREATOR = new Creator<ParceableModel>() {
        @Override
        public ParceableModel createFromParcel(Parcel in) {
            return new ParceableModel(in);
        }

        @Override
        public ParceableModel[] newArray(int size) {
            return new ParceableModel[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
