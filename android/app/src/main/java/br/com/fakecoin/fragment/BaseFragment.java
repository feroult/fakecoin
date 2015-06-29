package br.com.fakecoin.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.fakecoin.R;
import br.com.fakecoin.activity.MainActivity;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected Toolbar mToolbar;

    public MainActivity getDrawerActivity() {
        return ((MainActivity) super.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbar(view);
    }

    protected void setToolbar(View view) {
        if (!hasCustomToolbar()) {
            return;
        }

        mToolbar = ButterKnife.findById(view, getToolbarId());
        mToolbar.setTitle(getTitle());
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDrawerActivity().openDrawer();
            }
        });
    }

    public boolean hasCustomToolbar() {
        return false;
    }

    @IdRes
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @StringRes
    protected int getTitle() {
        return R.string.title_not_set;
    }

    @LayoutRes
    protected abstract int getLayout();
}
