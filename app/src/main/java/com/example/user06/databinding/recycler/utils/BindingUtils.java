package com.example.user06.databinding.recycler.utils;

/**
 * Created by Anjan Debnath on 10/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */


/**
 * convertToSuffix() method converts a number to human readable format.
 * For example, 5500L will be converted as 5.5k and 5050890L will be converted as 5.1m.
 *
 * We bind this function to TextViews in order to display the posts, followers and following in human readable format.
 */
public class BindingUtils {

    // https://stackoverflow.com/questions/9769554/how-to-convert-number-into-k-thousands-m-million-and-b-billion-suffix-in-jsp
    // Converts the number to K, M suffix
    // Ex: 5500 will be displayed as 5.5k
    public static String convertToSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f%c",
                count / Math.pow(1000, exp),
                "kmgtpe".charAt(exp - 1));
    }
}
