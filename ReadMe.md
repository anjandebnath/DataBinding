### Include Layout

Databinding allows to include any content layout inside a parent layout.

    <include
            layout="@layout/content_recycler"
            android:id="@+id/content"
            bind:user="@{user}"
            />

### Import Class

Databinding Allows to import any class.

    <import type="com.example.user06.databinding.recycler.utils.BindingUtils"/>

    <TextView
                android:id="@+id/textView"
                ...
                android:text="@{BindingUtils.convertToSuffix(user.numberOfFollowers)}"
                ...
                tools:textColor="@android:color/white" />

### Observables in Databinding

**@Binable** annotation is given to each property which you want to be observed.

**notifyPropertyChanged** if you want to notify any changes in a property inside your model class.

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

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

This is the custom click listener

     public class CustomClickHandlers{

        Context mContext;

        public CustomClickHandlers(Context context){
            mContext = context;
        }

        public void onProfileInfoFabClicked(View view){

            ...
        }

    }

in xml layout the clicklistener added

    <android.support.design.widget.FloatingActionButton
            android:id="@+id/fab"
            ...
            android:onClick="@{handler::onProfileInfoFabClicked}"/>


### RecyclerView Adapter

Inside Recyclerview view holder when databinding need to be used

then in the **constructor *View* will be replaced with *DataBinding* view**.

     public MyViewHolder(View itemView) {
            super(itemView);
        }

**will be replaced by**

    public class MyViewHolder extends RecyclerView.ViewHolder{

        PostRowItemBinding binding;

        public MyViewHolder(PostRowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

### Result

![](https://github.com/anjandebnath/DataBinding/blob/master/output.png)


### Reference Links

- https://inducesmile.com/android/android-databinding-example-tutorial/

- https://android.jlelse.eu/android-data-binding-binding-adapters-part-5-2bc91e43caa0

- http://www.coderzheaven.com/2017/01/30/databinding-in-android-using-observable-collections/



Thanks

Anjan Debnath