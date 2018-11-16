package academy.learnprogramming.ps1zadanie2;

import android.graphics.Color;

import java.util.Random;
public class DajColor
{

    public int getRandomColor(){
    Random rnd = new Random();
    return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
}
}
//public Color getColor(){return new Color(r,g,b)