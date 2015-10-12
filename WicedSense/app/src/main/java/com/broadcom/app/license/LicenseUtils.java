/******************************************************************************
 *
 *  Copyright (C) 2014 Broadcom Corporation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/
package com.broadcom.app.license;

import com.broadcom.app.license.LicenseDialog.OnLicenseAcceptListener;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Helper class to show the license dialog and saves the user's selection
 */
public class LicenseUtils implements OnLicenseAcceptListener {
    private static final String PREFS_ID = "LicensePrefs";
    private static final Integer PREFS_SET = 0;
    private static final String PREFS_HAS_ACCEPTED = "HasAccepted";
    private Context mContext;
    private boolean mHasAccepted;
    private LicenseDialog.OnLicenseAcceptListener mListener;
    private LicenseDialog mDialog;

    @Override
    public void onLicenseAccepted(boolean accepted) {
        mDialog = null;
        if (mListener != null) {
            mListener.onLicenseAccepted(accepted);
        }
    }

    public LicenseUtils(Context ctx, LicenseDialog.OnLicenseAcceptListener listener) {
        mContext = ctx;
        mListener = listener;
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_ID, PREFS_SET);
        if (prefs == null)
            return;
        mHasAccepted = prefs.getBoolean(PREFS_HAS_ACCEPTED, false);
    }

    public void setAccepted(boolean accepted) {
        mHasAccepted = accepted;
        SharedPreferences prefs = mContext.getSharedPreferences(PREFS_ID, PREFS_SET);
        SharedPreferences.Editor edit = prefs.edit();
        if (edit == null)
            return;

        edit.putBoolean(PREFS_HAS_ACCEPTED, mHasAccepted);
        edit.commit();
    }

    public boolean checkLicenseAccepted(FragmentManager mgr) {
        if (!mHasAccepted) {
            if (mDialog == null) {
                mDialog = new LicenseDialog();
                mDialog.setListener(this);
                mDialog.show(mgr, null);
            }
            return false;
        }
        return true;
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.setListener(null);
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
