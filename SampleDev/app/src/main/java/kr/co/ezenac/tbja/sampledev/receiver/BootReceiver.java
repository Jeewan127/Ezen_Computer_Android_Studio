package kr.co.ezenac.tbja.sampledev.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import kr.co.ezenac.tbja.sampledev.BroadCastActivity;

/**
 * Created by Administrator on 2017-12-06.
 */

public class BootReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Toast.makeText(context,"BOOT_COMPLETED",Toast.LENGTH_LONG).show();
            Log.d("ksj" ,"boot");
        } else if (intent.getAction().equals(BroadCastActivity.ACTION)) {
            Toast.makeText(context,BroadCastActivity.ACTION,Toast.LENGTH_LONG).show();
        }
    }
}
