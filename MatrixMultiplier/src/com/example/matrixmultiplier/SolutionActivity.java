package com.example.matrixmultiplier;

import java.util.Arrays;
import java.util.Map;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiInterstitial;
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

public class SolutionActivity extends Activity {
	private static final String TAG = SolutionActivity.class.getSimpleName();
	private static final long BANNER_PLACEMENT_ID = 1458967564949L;
	private static final long INTERSTITIAL_PLACEMENT_ID = 1459827822090L;
	private static final String ACCOUNT_ID = "4028cba632f2db85013300695de90166";

	EditText num1, num2, num3, num4, num5, num6, num7, num8, num9;
	int arr1[], arr2[], arr3[];
	InMobiInterstitial interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solution);
		// getting the intent values sent from MainActivity
		arr1 = getIntent().getIntArrayExtra("1stRow");
		arr2 = getIntent().getIntArrayExtra("2ndRow");
		arr3 = getIntent().getIntArrayExtra("3rdRow");
		initializeElements();
		setArrayElements();
		InMobiBanner imbanner = new InMobiBanner(this, BANNER_PLACEMENT_ID);

		RelativeLayout adContainer = (RelativeLayout) findViewById(R.id.sol_ad_container);
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

		int width = toPixelUnits(320);
		int height = toPixelUnits(50);
		RelativeLayout.LayoutParams bannerLayoutParams = new RelativeLayout.LayoutParams(
				width, height);
		bannerLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		bannerLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		adContainer.addView(imbanner, bannerLayoutParams);
		imbanner.load();

		InMobiInterstitial.InterstitialAdListener interstitialAdListener = new InMobiInterstitial.InterstitialAdListener() {
			@Override
			public void onAdLoadSucceeded(InMobiInterstitial ad) {
				if (ad.isReady()) {
					ad.show();
				}
			}

			@Override
			public void onAdLoadFailed(InMobiInterstitial ad,
					InMobiAdRequestStatus requestStatus) {
				Log.w(TAG, "Interstitial ad failed to load with error: "
						+ requestStatus.getMessage());
			}

			@Override
			public void onAdDisplayed(InMobiInterstitial ad) {
			}

			@Override
			public void onAdDismissed(InMobiInterstitial ad) {
			}

			@Override
			public void onAdInteraction(InMobiInterstitial ad,
					Map<Object, Object> params) {
			}

			@Override
			public void onAdRewardActionCompleted(InMobiInterstitial ad,
					Map<Object, Object> rewards) {
			}

			@Override
			public void onUserLeftApplication(InMobiInterstitial ad) {
			}
		};
		interstitial = new InMobiInterstitial(this, INTERSTITIAL_PLACEMENT_ID,
				interstitialAdListener);

	}

	/**
	 * finding the textBox Views
	 */
	private void initializeElements() {
		num1 = (EditText) findViewById(R.id.solEditText1);
		num2 = (EditText) findViewById(R.id.solEditText2);
		num3 = (EditText) findViewById(R.id.solEditText3);
		num4 = (EditText) findViewById(R.id.solEditText4);
		num5 = (EditText) findViewById(R.id.solEditText5);
		num6 = (EditText) findViewById(R.id.solEditText6);
		num7 = (EditText) findViewById(R.id.solEditText7);
		num8 = (EditText) findViewById(R.id.solEditText8);
		num9 = (EditText) findViewById(R.id.solEditText9);
	}

	/**
	 * Setting the textBox
	 */
	private void setArrayElements() {
		num1.setText(String.valueOf(arr1[0]));
		num2.setText(String.valueOf(arr1[1]));
		num3.setText(String.valueOf(arr1[2]));
		num4.setText(String.valueOf(arr2[0]));
		num5.setText(String.valueOf(arr2[1]));
		num6.setText(String.valueOf(arr2[2]));
		num7.setText(String.valueOf(arr3[0]));
		num8.setText(String.valueOf(arr3[1]));
		num9.setText(String.valueOf(arr3[2]));

	}

	/**
	 * InputAgain button action
	 */
	public void goToMainActivity(View v) {
		Intent i = new Intent();
		i.setClassName("com.example.matrixmultiplier",
				"com.example.matrixmultiplier.MainActivity");
		interstitial.load();
		startActivity(i);
	}
        @Override
	public void onBackPressed() {
		interstitial.load();
		super.onBackPressed();
	}
        
	private int toPixelUnits(int dipUnit) {
		float density = getResources().getDisplayMetrics().density;
		return Math.round(dipUnit * density);
	}
}
