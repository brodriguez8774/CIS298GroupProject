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
package com.broadcom.app.wicedsense;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Our Implimentation of HumidityFragment.
 * Will attempt to closely resemble practices done in class/assignments.
 */
public class HumidityFragment extends Fragment {

//region Variables

    private TextView mCurrent;
    private TextView mMin;
    private TextView mMax;
    private TextView mAvg;

    //endregion



    //region Static information to summon Fragment.
    private static final String ARG_HUMIDITY_ID= "humidity_id";

    private static HumidityFragment newInstance() {
        // Provided in case bundle is required in the future.
        Bundle args = new Bundle();

        // Make and return new fragment.
        HumidityFragment fragment = new HumidityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //endregion



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Use inflater to get view from layout.
        View view = inflater.inflate(R.layout.humidity_fragment, container, false);

        // Set class level vars to appropriate xml attributes.
        mCurrent = (TextView) view.findViewById(R.id.humidity_current);
        mMin = (TextView) view.findViewById(R.id.humidity_min);
        mMax = (TextView) view.findViewById(R.id.humidity_max);
        mAvg = (TextView) view.findViewById(R.id.humidity_avg);

        // Read in from database and set values here?

        return view;
    }
}

/**
 * WICEDSENCE default stuff.
 * Commenting out instead of removing in case we need to reference it to get the program running.
 *
 *
 *
 *
 */ /*
public class HumidityFragment extends BaseThermoFragment {

    @Override
    protected void initRangeValues() {
        mMaxValue = SensorDataParser.SENSOR_HUMIDITY_MAX;
        mMinValue = SensorDataParser.SENSOR_HUMIDITY_MIN;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.humidity_fragment, null);
        return v;
    }

    @Override
    protected void setGaugeText(float value) {
        if (mGaugeLevel == null) {
            return;
        }
        //mGaugeValue.setText(getString(R.string.humidity_value, String.format("%.1f", value)));
    }

    @Override
    protected String getPropertyName() {
        return "humd";
    }

} */
