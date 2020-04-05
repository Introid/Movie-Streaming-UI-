package com.introid.videostreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private List<Slide> firstSlide=new ArrayList<>(  );
    private ViewPager slidePager;
    private TabLayout indicator;
    private RecyclerView recyclerView;
    List<Movie> firstMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        slidePager= findViewById( R.id.slider_pager );
        indicator= findViewById( R.id.indicator );
        recyclerView= findViewById( R.id.rv_movie );

        firstSlide.add( new Slide( R.drawable.aquaman,"Aquaman " ) );
        firstSlide.add( new Slide( R.drawable.captain_america,"Captain America" ) );
        firstSlide.add( new Slide( R.drawable.aliens,"Aliens" ) );
        firstSlide.add( new Slide( R.drawable.let_me_in,"Let Me In" ) );

        SlidePagerAdapter slidePagerAdapter= new SlidePagerAdapter( this,firstSlide );
        slidePager.setAdapter(slidePagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate( new MainActivity.SlideTimer(),4000,6000 );

        indicator.setupWithViewPager(slidePager);

        List<Movie> firstMovies= new ArrayList<>();
        firstMovies.add( new Movie( "Dora" , R.drawable.dora) );
        firstMovies.add( new Movie( "Aliens" , R.drawable.aliens) );
        firstMovies.add( new Movie( "Aquaman" , R.drawable.aquaman) );
        firstMovies.add( new Movie( "Black Widow" , R.drawable.bb) );
        firstMovies.add( new Movie( "Blade Runner" , R.drawable.bladerunner) );
        firstMovies.add( new Movie( "Iron Man" , R.drawable.ironman) );
        firstMovies.add( new Movie( "Spider Man" , R.drawable.spiderman) );

        MovieAdapter movieAdapter= new MovieAdapter( this,firstMovies);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager( this,LinearLayoutManager.HORIZONTAL,false ) );


    }



    class SlideTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread( new Runnable() {
                @Override
                public void run() {
                    if (slidePager.getCurrentItem() < firstSlide.size()-1){
                        slidePager.setCurrentItem( slidePager.getCurrentItem()+1 );
                    }else
                        slidePager.setCurrentItem( 0 );
                }
            } );
        }
    }
}
