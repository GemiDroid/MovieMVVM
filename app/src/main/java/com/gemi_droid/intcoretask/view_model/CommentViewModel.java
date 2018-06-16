package com.gemi_droid.intcoretask.view_model;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.gemi_droid.intcoretask.data.network.models.Comments;
import java.util.List;

public class CommentViewModel extends ViewModel {


    public MutableLiveData<List<Comments>> getAllComments =new MutableLiveData<>();





}
