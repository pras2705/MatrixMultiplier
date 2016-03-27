package com.example.matrixmultiplier;

import java.util.Map;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.sdk.InMobiSdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private static final long BANNER_PLACEMENT_ID = 1458967564949L;
	private static final String ACCOUNT_ID = "4028cba632f2db85013300695de90166";

	EditText num1, num2, num3, num4, num5, num6, num7, num8, num9, num10,
			num11, num12, num13, num14, num15, num16, num17, num18;

	int firstArray[][] = new int[3][3];
	int secondArray[][] = new int[3][3];
	int productArray[][] = new int[3][3];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// finding the textbox views
		intializeNumbers();
		InMobiSdk.init(this, ACCOUNT_ID);
		InMobiBanner imbanner = new InMobiBanner(this, BANNER_PLACEMENT_ID);
		// finding the layout view for the BannerAd
		RelativeLayout adContainer = (RelativeLayout) findViewById(R.id.ad_container);
		imbanner.setListener(new InMobiBanner.BannerAdListener() {
			@Override
			public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
			}

			@Override
			public void onAdLoadFailed(InMobiBanner inMobiBanner,
					InMobiAdRequestStatus inMobiAdRequestStatus) {
				Log.w(TAG, "Banner ad failed to load with error: "
						+ inMobiAdRequestStatus.getMessage());
			}

			@Override
			public void onAdDisplayed(InMobiBanner inMobiBanner) {
			}

			@Override
			public void onAdDismissed(InMobiBanner inMobiBanner) {
			}

			@Override
			public void onAdInteraction(InMobiBanner inMobiBanner,
					Map<Object, Object> map) {
			}

			@Override
			public void onUserLeftApplication(InMobiBanner inMobiBanner) {
			}

			@Override
			public void onAdRewardActionCompleted(InMobiBanner inMobiBanner,
					Map<Object, Object> map) {
			}
		});
		// sizing and positioning(customizing) the ad layout
		int width = toPixelUnits(320);
		int height = toPixelUnits(50);
		RelativeLayout.LayoutParams bannerLayoutParams = new RelativeLayout.LayoutParams(
				width, height);
		bannerLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		bannerLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		adContainer.addView(imbanner, bannerLayoutParams);
		imbanner.load();

	}

	/**
	 * Finds the textbox views
	 */
	public void intializeNumbers() {
		num1 = (EditText) findViewById(R.id.editText1);
		num2 = (EditText) findViewById(R.id.editText6);
		num3 = (EditText) findViewById(R.id.editText7);
		num4 = (EditText) findViewById(R.id.editText4);
		num5 = (EditText) findViewById(R.id.editText5);
		num6 = (EditText) findViewById(R.id.editText8);
		num7 = (EditText) findViewById(R.id.editText9);
		num8 = (EditText) findViewById(R.id.editText10);
		num9 = (EditText) findViewById(R.id.editText11);
		num10 = (EditText) findViewById(R.id.editText2);
		num11 = (EditText) findViewById(R.id.editText3);
		num12 = (EditText) findViewById(R.id.editText12);
		num13 = (EditText) findViewById(R.id.editText13);
		num14 = (EditText) findViewById(R.id.editText14);
		num15 = (EditText) findViewById(R.id.editText15);
		num16 = (EditText) findViewById(R.id.editText16);
		num17 = (EditText) findViewById(R.id.editText17);
		num18 = (EditText) findViewById(R.id.editText18);
	}

	/**
	 * Submit button action of passing the solution to SolutionActivity
	 * 
	 * @param v
	 */
	public void submitSolution(View v) {
		calculateProduct();
		Intent i = new Intent();
		i.setClassName("com.example.matrixmultiplier",
				"com.example.matrixmultiplier.SolutionActivity");
		i.putExtra("1stRow", productArray[0]);
		i.putExtra("2ndRow", productArray[1]);
		i.putExtra("3rdRow", productArray[2]);
		startActivity(i);
	}

	/**
	 * 3 X 3 Matrix Multiplication
	 */
	public void calculateProduct() {
		getNumValuesandBuildMatrices();
		int c, d, k, sum = 0;
		for (c = 0; c < 3; c++) {
			for (d = 0; d < 3; d++) {
				for (k = 0; k < 3; k++) {
					sum = sum + firstArray[c][k] * secondArray[k][d];
				}
				productArray[c][d] = sum;
				sum = 0;
			}
		}
	}

	/**
	 * Building the individual matrices based on the inputs.
	 */
	public void getNumValuesandBuildMatrices() {
		firstArray[0][0] = (!num1.getText().toString().equals("")) ? Integer
				.parseInt(num1.getText().toString()) : 0;
		firstArray[0][1] = (!num2.getText().toString().equals("")) ? Integer
				.parseInt(num2.getText().toString()) : 0;
		firstArray[0][2] = (!num3.getText().toString().equals("")) ? Integer
				.parseInt(num3.getText().toString()) : 0;
		firstArray[1][0] = (!num4.getText().toString().equals("")) ? Integer
				.parseInt(num4.getText().toString()) : 0;
		firstArray[1][1] = (!num5.getText().toString().equals("")) ? Integer
				.parseInt(num5.getText().toString()) : 0;
		firstArray[1][2] = (!num6.getText().toString().equals("")) ? Integer
				.parseInt(num6.getText().toString()) : 0;
		firstArray[2][0] = (!num7.getText().toString().equals("")) ? Integer
				.parseInt(num7.getText().toString()) : 0;
		firstArray[2][1] = (!num8.getText().toString().equals("")) ? Integer
				.parseInt(num8.getText().toString()) : 0;
		firstArray[2][2] = (!num9.getText().toString().equals("")) ? Integer
				.parseInt(num9.getText().toString()) : 0;
		secondArray[0][0] = (!num10.getText().toString().equals("")) ? Integer
				.parseInt(num10.getText().toString()) : 0;
		secondArray[0][1] = (!num11.getText().toString().equals("")) ? Integer
				.parseInt(num11.getText().toString()) : 0;
		secondArray[0][2] = (!num12.getText().toString().equals("")) ? Integer
				.parseInt(num12.getText().toString()) : 0;
		secondArray[1][0] = (!num13.getText().toString().equals("")) ? Integer
				.parseInt(num13.getText().toString()) : 0;
		secondArray[1][1] = (!num14.getText().toString().equals("")) ? Integer
				.parseInt(num14.getText().toString()) : 0;
		secondArray[1][2] = (!num15.getText().toString().equals("")) ? Integer
				.parseInt(num15.getText().toString()) : 0;
		secondArray[2][0] = (!num16.getText().toString().equals("")) ? Integer
				.parseInt(num16.getText().toString()) : 0;
		secondArray[2][1] = (!num17.getText().toString().equals("")) ? Integer
				.parseInt(num17.getText().toString()) : 0;
		secondArray[2][2] = (!num18.getText().toString().equals("")) ? Integer
				.parseInt(num18.getText().toString()) : 0;
	}

	private int toPixelUnits(int dipUnit) {
		float density = getResources().getDisplayMetrics().density;
		return Math.round(dipUnit * density);
	}
}
