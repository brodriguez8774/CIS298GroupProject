/******************************************************************************
 *
 *  Copyright (C) 2013-2014 Broadcom Corporation
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

/**
 * NOTE: replace "R.class" with your R.class declared in your application
 * Also, make sure you include the following resources
 * assets/license.html
 * layout/dialog_license.xml
 * values/strings_license.xml
 */
import com.broadcom.app.wicedsense.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Dialog that displays the license's terms and conditions
 *
 */
public class LicenseDialog extends DialogFragment implements OnClickListener {
    public interface OnLicenseAcceptListener {
        public abstract void onLicenseAccepted(boolean accepted);
    }

    private OnLicenseAcceptListener listener = null;
    private boolean mLicenseAccepted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_license, container);
        TextView tv = (TextView) view.findViewById(R.id.license_text);

        Button btn = (Button) view.findViewById(R.id.btnAccept);
        btn.setOnClickListener(this);

        try {
            StringBuilder sb = new StringBuilder();
            String str;

            InputStream is = getActivity().getAssets().open("license.html");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();

            tv.setText(Html.fromHtml(sb.toString()));
        } catch (IOException ex) {
        }

        getDialog().setTitle(R.string.title_license);

        return view;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        mLicenseAccepted = false;
        if (listener != null)
            listener.onLicenseAccepted(false);
        super.onCancel(dialog);
    }

    @Override
    public void onClick(View view) {
        mLicenseAccepted = true;
        if (listener != null)
            listener.onLicenseAccepted(true);
        dismiss();
    }


    //---------------------Public APIs--------------------------
    public void setListener(OnLicenseAcceptListener listener) {
        this.listener = listener;
    }

    public boolean isLicenseAccepted() {
        return mLicenseAccepted;
    }

}
