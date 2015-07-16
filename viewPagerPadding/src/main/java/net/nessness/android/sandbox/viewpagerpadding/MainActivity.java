package net.nessness.android.sandbox.viewpagerpadding;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SeekBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import net.nessness.android.viewpagerpaddingexample.R;

public class MainActivity extends AppCompatActivity {

  SectionsPagerAdapter mSectionsPagerAdapter;

  @Bind(R.id.pager)
  ViewPager mViewPager;

  @Bind(R.id.seek)
  SeekBar mPaddingSetter;

  @Bind(R.id.btn_left)
  Button mLeftButton;

  @Bind(R.id.btn_right)
  Button mRightButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    final int count = 10;
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), count);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
      @Override
      public void onPageSelected(int position) {
        final int lastPosition = mViewPager.getAdapter().getCount() - 1;
        mLeftButton.setEnabled(position != 0);
        mRightButton.setEnabled(position != lastPosition);
      }
    });

    mPaddingSetter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mViewPager.setPadding(progress, mViewPager.getPaddingTop(), progress, mViewPager.getPaddingBottom());
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
  }

  @OnClick(R.id.btn_left)
  public void onLeftClick() {
    final int pos = mViewPager.getCurrentItem();
    if (pos > 0) {
      mViewPager.setCurrentItem(pos - 1);
    }
  }

  @OnClick(R.id.btn_right)
  public void onRightClick() {
    final int pos = mViewPager.getCurrentItem();
    if (pos < mViewPager.getAdapter().getCount() - 1) {
      mViewPager.setCurrentItem(pos + 1);
    }
  }
}
