package kstn.game.view.screen;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup extends View implements ViewManager {
    protected List<View> viewList = new ArrayList<View>();

    public ViewGroup() {
        super();
    }

    public ViewGroup(float centerX, float centerY, float width, float height) {
        super(centerX, centerY, width, height);
    }

    @Override
    public void addView(View view) {
        viewList.add(view);
    }

    /*public void remove() {
        viewList.remove(1);
        viewList.remove(1);

    }*/
    @Override
    public void removeView(View view) {
        viewList.remove(view);
    }

    @Override
    public void clear() {
        viewList.clear();
    }

    @Override
    public View onTouch(TouchEvent event) {
        if (event.getType() == TouchEvent.TOUCH_DOWN) {
            float x = event.getX();
            float y = event.getY();
            if (x > centerX + width / 2 || x < centerX - width / 2)
                return null;
            if (y > centerY + height / 2 || y < centerY - height / 2)
                return null;
        }
        for (View view: viewList) {
            View result = view.onTouch(event);
            if (result != null)
                return result;
        }
        return super.onTouch(event);
    }

    @Override
    public void onDraw() {
        for (View view: viewList)
            view.onDraw();
    }

    @Override
    public void onSurfaceCreated() {
        for (View view: viewList)
            view.onSurfaceCreated();
    }

    @Override
    public void onSurfaceChanged(float screenWidth, float screenHeight) {
        this.width = screenWidth;
        this.height = screenHeight;
        for (View view: viewList)
            view.onSurfaceChanged(screenWidth, screenHeight);
    }
}
