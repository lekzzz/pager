package com.pager;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.widget.TextView;

public class OnboardingActivity extends AppCompatActivity {

    private TextView mSomeText;
    private int mCurrentSelectedScreen = 0;
    private int mNextSelectedScreen = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager mViewPager = findViewById(R.id.container);
        mSomeText = findViewById(R.id.some_text);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if ( position == mCurrentSelectedScreen )
                {
                    //  We are moving to next screen on right side
                    if ( positionOffset > 0.5 )
                    {
                        mSomeText.setAlpha((positionOffset - 0.5F) * 2);
//                         Closer to next screen than to current
                        if ( position + 1 != mNextSelectedScreen )
                        {
                            mNextSelectedScreen = position + 1;
                            updateStaticViewsForScreen( mNextSelectedScreen );
                        }
                    }
                    else
                    {
                        mSomeText.setAlpha(1 - 2 * positionOffset);
                        // Closer to current screen than to next
                        if ( position != mNextSelectedScreen )
                        {
                            mNextSelectedScreen = position;
                            updateStaticViewsForScreen( mNextSelectedScreen );
                        }
                    }
                }
                else
                {
                    // We are moving to next screen left side
                    if ( positionOffset > 0.5 )
                    {
                        mSomeText.setAlpha((positionOffset - 0.5F) * 2);
                        // Closer to current screen than to next
                        if ( position + 1 != mNextSelectedScreen )
                        {
                            mNextSelectedScreen = position + 1;
                            updateStaticViewsForScreen( mNextSelectedScreen );
                        }
                    }
                    else
                    {
                        mSomeText.setAlpha(1 - 2 * positionOffset);
                        // Closer to next screen than to current
                        if ( position != mNextSelectedScreen )
                        {
                            mNextSelectedScreen = position;
                            updateStaticViewsForScreen( mNextSelectedScreen );
                        }
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                updateStaticViewsForScreen( position );
                mCurrentSelectedScreen = position;
                mNextSelectedScreen = position;
            }

            @Override
            public void onPageScrollStateChanged(int position) {
            }
        });
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    private void updateStaticViewsForScreen(int pos) {
        mSomeText.setText(getResources().getStringArray(R.array.onboarding)[pos]);
    }
}
