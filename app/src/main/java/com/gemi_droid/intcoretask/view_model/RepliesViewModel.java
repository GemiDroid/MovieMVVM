package com.gemi_droid.intcoretask.view_model;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.gemi_droid.intcoretask.data.network.models.Replies;
import java.util.List;

public class RepliesViewModel extends ViewModel {


    public MutableLiveData<List<Replies>> getAllReplies =new MutableLiveData<>();





}
