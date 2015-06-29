package br.com.fakecoin.fragment;

import br.com.fakecoin.R;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {

    }

    @Override
    protected int getTitle() {
        return R.string.home_fragment_title;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }
}
