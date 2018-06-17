package com.gemi_droid.intcoretask.data.utilits;

import android.content.Context;
import android.content.Intent;

import com.gemi_droid.intcoretask.R;

/**
 * Created by pc on 06/17/2018.
 */

public class ShareUtility {

    public static void share(Context context,String title_ar) {

        Intent intent_share = new Intent(Intent.ACTION_SEND);
        intent_share.putExtra(Intent.EXTRA_TEXT, title_ar);
        intent_share.setType("text/*");
        Intent.createChooser(intent_share, context.getString(R.string.share_via));
        context.startActivity(intent_share);
    }
}
