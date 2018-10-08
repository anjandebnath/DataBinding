package com.example.user06.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Anjan Debnath on 2/27/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

public class PersonVO extends BaseObservable {

    private String name;
    private String occupation;

    public PersonVO(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
        notifyPropertyChanged(BR.occupation);
    }
}
