package com.example.user06.databinding;

import android.databinding.ObservableDouble;
import android.databinding.ObservableField;

/**
 * Created by Anjan Debnath on 2/27/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

public class PersonVOField {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> occupation = new ObservableField<>();
    public final ObservableDouble age = new ObservableDouble();


}
