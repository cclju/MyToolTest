package com.mytooltest.marquee.recycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

/**
 * Created by jarvis on 2018/9/26.
 */

public class AutoPollRecyclerView extends RecyclerView {

//    private static final long TIME_AUTO_POLL = 16;
    private static final long TIME_AUTO_POLL = 2000;
    AutoPollTask autoPollTask;
    private boolean running; //表示是否正在自动轮询
    private boolean canRun;//表示是否可以自动轮询

//    private int pos = 0;

    public AutoPollRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        autoPollTask = new AutoPollTask(this);
    }

    static class AutoPollTask implements Runnable {
        private final WeakReference<AutoPollRecyclerView> mReference;

        //使用弱引用持有外部类引用->防止内存泄漏
        public AutoPollTask(AutoPollRecyclerView reference) {
            this.mReference = new WeakReference<AutoPollRecyclerView>(reference);
        }

        @Override
        public void run() {
            final AutoPollRecyclerView recyclerView = mReference.get();
            if (recyclerView != null && recyclerView.running && recyclerView.canRun) {

                // 方法一
//                recyclerView.scrollBy(100, 100);

                // 方法二 有动画效果
                Log.d("AutoPollRecyclerView", "run……");
                ((AutoPollAdapter)recyclerView.getAdapter()).marqueeData();

//                recyclerView.smoothScrollToPosition(recyclerView.pos++);

                recyclerView.postDelayed(recyclerView.autoPollTask, TIME_AUTO_POLL);
            }
        }
    }

    //开启:如果正在运行,先停止->再开启
    public void start() {
        if (running)
            stop();
        canRun = true;
        running = true;
        postDelayed(autoPollTask, TIME_AUTO_POLL);
    }

    public void stop() {
        running = false;
        removeCallbacks(autoPollTask);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//        return super.onInterceptTouchEvent(e);
//        return true;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
//        switch (e.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                if (running)
//                    stop();
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_OUTSIDE:
//                if (canRun)
//                    start();
//                break;
//        }
//        return super.onTouchEvent(e);

        return true;
    }
}
