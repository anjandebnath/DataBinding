### Include Layout

Databinding allows to include any layout

    <include
            layout="@layout/content_recycler"
            android:id="@+id/content"
            bind:user="@{user}"
            />

### Import

Databinding Allows to import any class

    <import type="com.example.user06.databinding.recycler.utils.BindingUtils"/>
    <TextView
                android:id="@+id/textView"
                ...
                android:text="@{BindingUtils.convertToSuffix(user.numberOfFollowers)}"
                ...
                tools:textColor="@android:color/white" />

### Binding Adapters

BindingAdapter annotation allows to customize how a setter for an attribute is called.

    @BindingAdapter({"profileImage"})
        public static void loadImage(ImageView view, String imageUrl){

            Glide.with(view.getContext())
                    .load(imageUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(view);
        }
Above example will load image url by using the attribute **profileImage** used anywhere in layout! (in whole app of course).

        <ImageView
            android:id="@+id/imageView3"
            ....
            bind:profileImage="@{user.profileImage}"
            ....
            app:srcCompat="@drawable/profile_img" />


### Click Handlers



### Reference Links

- https://inducesmile.com/android/android-databinding-example-tutorial/

- https://android.jlelse.eu/android-data-binding-binding-adapters-part-5-2bc91e43caa0

- http://www.coderzheaven.com/2017/01/30/databinding-in-android-using-observable-collections/



Thanks

Anjan Debnath