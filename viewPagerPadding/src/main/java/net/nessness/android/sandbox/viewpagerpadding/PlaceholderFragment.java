package net.nessness.android.sandbox.viewpagerpadding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import net.nessness.android.viewpagerpaddingexample.R;

public class PlaceholderFragment extends Fragment {

  private static final String ARG_SECTION_NUMBER = "section_number";

  public static PlaceholderFragment newInstance(int sectionNumber) {
    PlaceholderFragment fragment = new PlaceholderFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    fragment.setArguments(args);
    return fragment;
  }

  public PlaceholderFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View v = inflater.inflate(R.layout.fragment_main, container, false);
    final TextView label = (TextView) v.findViewById(R.id.section_label);
    label.setText(String.format(Locale.getDefault(), "This is page %d", getArguments().getInt(ARG_SECTION_NUMBER)));
    return v;
  }
}
