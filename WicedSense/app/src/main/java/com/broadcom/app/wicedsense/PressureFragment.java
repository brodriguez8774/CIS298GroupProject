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
 * Our Implimentation of PressureFragment.
 * Will attempt to closely resemble practices done in class/assignments.
 */
public class PressureFragment extends Fragment {

//region Variables

    private TextView mCurrent;
    private TextView mMin;
    private TextView mMax;
    private TextView mAvg;

    //endregion



    //region Static information to summon Fragment.
    private static final String ARG_PRESSURE_ID= "pressure_id";

    private static PressureFragment newInstance() {
        // Provided in case bundle is required in the future.
        Bundle args = new Bundle();

        // Make and return new fragment.
        PressureFragment fragment = new PressureFragment();
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
        View view = inflater.inflate(R.layout.speed_fragment, container, false);

        // Set class level vars to appropriate xml attributes.
        mCurrent = (TextView) view.findViewById(R.id.pressure_current);
        mMin = (TextView) view.findViewById(R.id.pressure_min);
        mMax = (TextView) view.findViewById(R.id.pressure_max);
        mAvg = (TextView) view.findViewById(R.id.pressure_avg);

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
public class PressureFragment extends BaseThermoFragment {

    @Override
    public void initRangeValues() {
        mMaxValue = SensorDataParser.SENSOR_PRESSURE_MAX;
        mMinValue = SensorDataParser.SENSOR_PRESSURE_MIN;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pressure_fragment, null);
        return v;
    }

    @Override
    protected void setGaugeText(float value) {
        //GaugeValue.setText(getString(R.string.pressure_value, String.valueOf((int) value)));
    }

    @Override
    protected String getPropertyName() {
        return "pres";
    }

} */
