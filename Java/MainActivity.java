package com.belarus.greenway;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    RoutesFragment routesFragment;
    LandmarkFragment landmarkFragment;
    EntertainmentsFragment entertainmentsFragment;
    ResidenceFragment residenceFragment;

    FragmentTransaction fTrans;
    FragmentManager fragmentManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        routesFragment = new RoutesFragment();
        landmarkFragment = new LandmarkFragment();
        entertainmentsFragment = new EntertainmentsFragment();
        residenceFragment = new ResidenceFragment();


    }


    public void onClick(View v) {

        fragmentManager = getSupportFragmentManager();
        fTrans = fragmentManager.beginTransaction();

        //Реализация нажатий кнопок
        switch (v.getId()) {
            case R.id.btnRoutes: //Маршруты
                fTrans.replace(R.id.frgmCont, routesFragment);
                break;

            case R.id.btnLandmark: //Достопримечательности
                fTrans.replace(R.id.frgmCont,landmarkFragment);
                break;

            case R.id.btnEntertainments: //Развлечения
                fTrans.replace(R.id.frgmCont, entertainmentsFragment);
                break;

            case R.id.btnResidence: //Проживание
                fTrans.replace(R.id.frgmCont, residenceFragment);
                break;

            default:
                break;
        }

        //Возвращает предыдущее состояние фрагмента при нажатии кнопки назад
        fTrans.addToBackStack(null);
        fTrans.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu); //отображает кнопку поиска
        return super.onCreateOptionsMenu(menu);
    }
}
