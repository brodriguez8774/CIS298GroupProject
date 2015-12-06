package com.broadcom.app.wicedsense;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Abstract class for creating a fragment.
 * May need to change to multiple fragment activity at a later date? Not sure what the difference
 * would be as far as code.
 */
public abstract class MultipleFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get id of xml-associated file.
        setContentView(R.layout.activity_fragment);

        // Create a new Fragment Manager.
        FragmentManager fm = getSupportFragmentManager();

        // Find fragment inside the FM, if currently exists.
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // If fragment is null, create new one.
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    // Abstract method to return a fragment for use.
    protected abstract Fragment createFragment();
}
