package eu.codlab.amiiwrite.ui.drawer;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.provider.DocumentFile;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import eu.codlab.amiiwrite.MainActivity;
import eu.codlab.amiiwrite.R;
import eu.codlab.amiiwrite.ui._stack.StackController;
import eu.codlab.amiiwrite.ui.my_list.EventMyList;
import eu.codlab.amiiwrite.ui.scan.fragments.ScanFragment;
import eu.codlab.amiiwrite.ui.scan.fragments.ScannedAmiiboFragment;

public class MenuDrawer extends Fragment {
    private static final String URL_GITHUB = "http://github.com/skyforce77/unsafeamiiwrite";

    public MenuDrawer() {
        // Required empty public constructor
    }

    @OnClick(R.id.my_amiibos)
    public void onClickOnMyAmiibo() {
        EventBus.getDefault().post(new EventMyList.EventLoadCategories());
    }

    @OnClick(R.id.addbin)
    public void onClickAddBinary() {
        ((MainActivity) getActivity()).addBinary();
    }

    @OnClick(R.id.github)
    public void onClickGithub() {
        showUrl(URL_GITHUB);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuDrawer.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuDrawer newInstance(String param1, String param2) {
        MenuDrawer fragment = new MenuDrawer();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_drawer, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
    }


    private void showUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
