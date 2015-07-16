package net.nessness.android.sandbox.viewpagerpadding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

  private final int mCount;

  public SectionsPagerAdapter(FragmentManager fm, int count) {
    super(fm);
    mCount = count;
  }

  @Override
  public Fragment getItem(int position) {
    return PlaceholderFragment.newInstance(position);
  }

  @Override
  public int getCount() {
    return mCount;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return "page: " + position;
  }
}
