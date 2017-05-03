package com.example.samsung.p1051_fragmentdynamic;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentTransaction fragmentTransaction;
    CheckBox chbAddToBackStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        chbAddToBackStack = (CheckBox) findViewById(R.id.chbAddToBackStack);
    }

    public void onClickBtn(View view) {

        fragmentTransaction = getFragmentManager().beginTransaction();

        switch (view.getId()) {

            case R.id.btnAdd :
                fragmentTransaction.add(R.id.flCont, fragment1);
                break;
            case R.id.btnRemove :
                fragmentTransaction.remove(fragment1);
                break;
            case R.id.btnReplace :
                fragmentTransaction.replace(R.id.flCont, fragment2);
                break;
            default:
                break;

        }

        if (chbAddToBackStack.isChecked()) fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }
}
