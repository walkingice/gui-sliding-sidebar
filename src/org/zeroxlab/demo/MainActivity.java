package org.zeroxlab.demo;

import org.zeroxlab.widget.AnimationLayout;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.*;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity implements AnimationLayout.Listener {
    public final static String TAG = "Demo";

    protected ListView        mList;
    protected AnimationLayout mLayout;
    protected String[] mStrings = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mLayout = (AnimationLayout) findViewById(R.id.animation_layout);
        mLayout.setListener(this);

        mList   = (ListView) findViewById(R.id.sidebar_list);
        mList.setAdapter(
                new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_multiple_choice
                    , mStrings));
        mList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public void onClickContentButton(View v) {
        mLayout.toggleSidebar();
    }

    /* Callback of AnimationLayout.Listener to monitor status of Sidebar */
    @Override
    public void onSidebarOpened() {
        Log.d(TAG, "opened");
    }

    /* Callback of AnimationLayout.Listener to monitor status of Sidebar */
    @Override
    public void onSidebarClosed() {
        Log.d(TAG, "opened");
    }

    /* Callback of AnimationLayout.Listener to monitor status of Sidebar */
    @Override
    public boolean onContentTouchedWhenOpening() {
        // the content area is touched when sidebar opening, close sidebar
        Log.d(TAG, "going to close sidebar");
        mLayout.closeSidebar();
        return true;
    }
}

