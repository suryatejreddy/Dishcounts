package dhcs.com.dishcounts.Fragments;
import dhcs.com.dishcounts.Adapters.ImageViewPagerAdapter;
import android.widget.Button;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.com.dishcounts.R;
import android.widget.ImageView;

public class MainFragment extends Fragment {
    private ViewPager _mViewPager;
    private ImageViewPagerAdapter _adapter;
    private ImageView _btn1, _btn2, _btn3, _btn4;

    public MainFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpView();
        setTab();
        onCircleButtonClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void onCircleButtonClick() {
        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btn1.setImageResource(R.drawable.circlefilled);
                _mViewPager.setCurrentItem(0);
            }
        });
        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btn2.setImageResource(R.drawable.circlefilled);
                _mViewPager.setCurrentItem(1);
            }
        });
        _btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btn3.setImageResource(R.drawable.circlefilled);
                _mViewPager.setCurrentItem(2);
            }
        });
        _btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btn4.setImageResource(R.drawable.circlefilled);
                _mViewPager.setCurrentItem(3);
            }
        });
    }

    private void setUpView() {
        _mViewPager = getView().findViewById(R.id.imageviewPager);
        _adapter = new ImageViewPagerAdapter(getActivity(), getFragmentManager());
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
        initButton();
    }

    private void setTab() {
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int position) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                _btn1.setImageResource(R.drawable.circle);
                _btn2.setImageResource(R.drawable.circle);
                _btn3.setImageResource(R.drawable.circle);
                _btn4.setImageResource(R.drawable.circle);
                btnAction(position);
            }
        });
    }

    private void btnAction(int action) {
        switch (action) {
            case 0:
                _btn1.setImageResource(R.drawable.circlefilled);
                break;
            case 1:
                _btn2.setImageResource(R.drawable.circlefilled);
                break;
            case 2:
                _btn3.setImageResource(R.drawable.circlefilled);
                break;
            case 3:
                _btn4.setImageResource(R.drawable.circlefilled);
        }
    }

    private void initButton() {
        _btn1 = getView().findViewById(R.id.circular_button1);
        _btn1.setImageResource(R.drawable.circlefilled);
        _btn2 = getView().findViewById(R.id.circular_button2);
        _btn3 = getView().findViewById(R.id.circular_button3);
        _btn4 = getView().findViewById(R.id.circular_button4);
    }

    private void setButton(Button btn, String text, int h, int w) {
        btn.setWidth(w);
        btn.setHeight(h);
        btn.setText(text);
    }
}
