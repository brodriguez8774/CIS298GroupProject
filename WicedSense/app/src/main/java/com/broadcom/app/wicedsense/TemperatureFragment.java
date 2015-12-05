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
 * Our Implimentation of TemperatureFragment.
 * Will attempt to closely resemble practices done in class/assignments.
 */
public class TemperatureFragment extends Fragment {

    //region Variables

    private TextView mCurrent;
    private TextView mMin;
    private TextView mMax;
    private TextView mAvg;

    //endregion



    //region Static information to summon Fragment.
    private static final String ARG_TEMPERATURE_ID= "temperature_id";

    private static TemperatureFragment newInstance() {
        // Provided in case bundle is required in the future.
        Bundle args = new Bundle();

        // Make and return new fragment.
        TemperatureFragment fragment = new TemperatureFragment();
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
        View view = inflater.inflate(R.layout.temperature_fragment, container, false);

        // Set class level vars to appropriate xml attributes.
        mCurrent = (TextView) view.findViewById(R.id.temp_current);
        mMin = (TextView) view.findViewById(R.id.temp_min);
        mMax = (TextView) view.findViewById(R.id.temp_max);
        mAvg = (TextView) view.findViewById(R.id.temp_avg);

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
 * Fragment for the temperature widget. Supports both F and C scales
 * <p/>
 * NOTE: caller of setValue() is expected to pass in the temperature with the
 * correct scaled value. *
 */
/*
public class TemperatureFragment extends BaseThermoFragment {
    public static final int SCALE_F = 0;
    public static final int SCALE_C = 1;

    private int mScaleType = SCALE_F;

    @Override
    protected void initRangeValues() {
        if (mScaleType == SCALE_F) {
            mMaxValue = SensorDataParser.SENSOR_TEMP_MAX_F;
            mMinValue = SensorDataParser.SENSOR_TEMP_MIN_F;
        } else {
            mMaxValue = SensorDataParser.SENSOR_TEMP_MAX_C;
            mMinValue = SensorDataParser.SENSOR_TEMP_MIN_C;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mScaleType == SCALE_F) {
            return inflater.inflate(R.layout.temperature_fragment, null);
        } else {
            return inflater.inflate(R.layout.temperature_fragment_c, null);
        }
    }

    @Override
    protected void setGaugeText(float value) {
        if (mScaleType == SCALE_F) {
           // mGaugeValue.setText(getString(R.string.temperature_value_f,
                    //String.format("%.1f", value)));
        } else {
            //mGaugeValue.setText(getString(R.string.temperature_value_c,
                    //String.format("%.1f", value)));
        }
    }

    @Override
    protected String getPropertyName() {
        return "temp";
    }

    public void setScaleType(int scaleType) {
        mScaleType = scaleType;
        initRange();
    }

    public int getScaleType() {
        return mScaleType;
    }

    public float getLastValue() {
        return mValue;

    }
} */
