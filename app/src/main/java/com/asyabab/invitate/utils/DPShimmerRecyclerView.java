
package com.asyabab.invitate.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asyabab.invitate.R;


public class DPShimmerRecyclerView extends RecyclerView {

    private Adapter mActualAdapter;
    private DPShimmerAdapter mShimmerAdapter;
    private LayoutManager mShimmerLayoutManager;
    private LayoutManager mActualLayoutManager;
    private LayoutMangerType mLayoutMangerType;
    private boolean mCanScroll;
    private int mLayoutReference;
    private int mGridCount;

    public DPShimmerRecyclerView(Context context) {
        super(context);
        init(context, null);
    }

    public DPShimmerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DPShimmerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mShimmerAdapter = new DPShimmerAdapter();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DPShimmerRecyclerView, 0, 0);

        int mShimmerAngle;
        int mShimmerColor;
        int mShimmerDuration;
        float mShimmerMaskWidth;
        boolean isAnimationReversed;
        Drawable mShimmerItemBackground;

        try {
            setDemoLayoutReference(a.getResourceId(R.styleable.DPShimmerRecyclerView_shimmer_demo_layout, R.layout.dp_layout_sample_view));
            setDemoChildCount(a.getInteger(R.styleable.DPShimmerRecyclerView_shimmer_demo_child_count, 10));
            setGridChildCount(a.getInteger(R.styleable.DPShimmerRecyclerView_shimmer_demo_grid_child_count, 2));

            final int value = a.getInteger(R.styleable.DPShimmerRecyclerView_shimmer_demo_layout_manager_type, 0);
            switch (value) {
                case 0:
                    setDemoLayoutManager(LayoutMangerType.LINEAR_VERTICAL);
                    break;
                case 1:
                    setDemoLayoutManager(LayoutMangerType.LINEAR_HORIZONTAL);
                    break;
                case 2:
                    setDemoLayoutManager(LayoutMangerType.GRID);
                    break;
                default:
                    throw new IllegalArgumentException("This value for layout manager is not valid!");
            }

            mShimmerAngle = a.getInteger(R.styleable.DPShimmerRecyclerView_shimmer_demo_angle, 0);
            mShimmerColor = a.getColor(R.styleable.DPShimmerRecyclerView_shimmer_demo_shimmer_color, getColor(R.color.default_shimmer_color));
            mShimmerItemBackground = a.getDrawable(R.styleable.DPShimmerRecyclerView_shimmer_demo_view_holder_item_background);
            mShimmerDuration = a.getInteger(R.styleable.DPShimmerRecyclerView_shimmer_demo_duration, 1500);
            mShimmerMaskWidth = a.getFloat(R.styleable.DPShimmerRecyclerView_shimmer_demo_mask_width, 0.5f);
            isAnimationReversed = a.getBoolean(R.styleable.DPShimmerRecyclerView_shimmer_demo_reverse_animation, false);
        } finally {
            a.recycle();
        }

        mShimmerAdapter.setShimmerAngle(mShimmerAngle);
        mShimmerAdapter.setShimmerColor(mShimmerColor);
        mShimmerAdapter.setShimmerMaskWidth(mShimmerMaskWidth);
        mShimmerAdapter.setShimmerItemBackground(mShimmerItemBackground);
        mShimmerAdapter.setShimmerDuration(mShimmerDuration);
        mShimmerAdapter.setAnimationReversed(isAnimationReversed);

        showShimmerAdapter();
    }

    /**
     * Specifies the number of child should exist in any row of the grid layout.
     *
     * @param count - count specifying the number of child.
     */
    public void setGridChildCount(int count) {
        mGridCount = count;
    }

    /**
     * Sets the layout manager for the shimmer adapter.
     *
     * @param type layout manager reference
     */
    public void setDemoLayoutManager(LayoutMangerType type) {
        mLayoutMangerType = type;
    }

    /**
     * Sets the number of demo views should be shown in the shimmer adapter.
     *
     * @param count - number of demo views should be shown.
     */
    public void setDemoChildCount(int count) {
        mShimmerAdapter.setMinItemCount(count);
    }

    /**
     * Specifies the animation duration of shimmer layout.
     *
     * @param duration - count specifying the duration of shimmer in millisecond.
     */
    public void setDemoShimmerDuration(int duration) {
        mShimmerAdapter.setShimmerDuration(duration);
    }

    /**
     * Specifies the the width of the shimmer line.
     *
     * @param maskWidth - float specifying the width of shimmer line. The value should be from 0 to less or equal to 1.
     *                  The default value is 0.5.
     */
    public void setDemoShimmerMaskWidth(float maskWidth) {
        mShimmerAdapter.setShimmerMaskWidth(maskWidth);
    }

    /**
     * Sets the shimmer adapter and shows the loading screen.
     */
    public void showShimmerAdapter() {
        mCanScroll = false;

        if (mShimmerLayoutManager == null) {
            initShimmerManager();
        }

        setLayoutManager(mShimmerLayoutManager);
        setAdapter(mShimmerAdapter);
    }

    /**
     * Hides the shimmer adapter
     */
    public void hideShimmerAdapter() {
        mCanScroll = true;
        setLayoutManager(mActualLayoutManager);
        setAdapter(mActualAdapter);
    }

    public void setLayoutManager(LayoutManager manager) {
        if (manager == null) {
            mActualLayoutManager = null;
        } else if (manager != mShimmerLayoutManager) {
            mActualLayoutManager = manager;
        }

        super.setLayoutManager(manager);
    }

    public void setAdapter(Adapter adapter) {
        if (adapter == null) {
            mActualAdapter = null;
        } else if (adapter != mShimmerAdapter) {
            mActualAdapter = adapter;
        }

        super.setAdapter(adapter);
    }

    /**
     * Retrieves the actual adapter that contains the data set or null if no adapter is set.
     *
     * @return The actual adapter
     */
    public Adapter getActualAdapter() {
        return mActualAdapter;
    }

    public Adapter getShimmerAdapter() {
        return mShimmerAdapter;
    }

    public int getLayoutReference() {
        return mLayoutReference;
    }

    /**
     * Sets the demo layout reference
     *
     * @param mLayoutReference layout resource id of the layout which should be shown as demo.
     */
    public void setDemoLayoutReference(int mLayoutReference) {
        this.mLayoutReference = mLayoutReference;
        mShimmerAdapter.setLayoutReference(getLayoutReference());
    }

    private void initShimmerManager() {
        switch (mLayoutMangerType) {
            case LINEAR_VERTICAL:
                mShimmerLayoutManager = new LinearLayoutManager(getContext()) {
                    public boolean canScrollVertically() {
                        return mCanScroll;
                    }
                };
                break;
            case LINEAR_HORIZONTAL:
                mShimmerLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) {
                    public boolean canScrollHorizontally() {
                        return mCanScroll;
                    }
                };
                break;
            case GRID:
                mShimmerLayoutManager = new GridLayoutManager(getContext(), mGridCount) {
                    public boolean canScrollVertically() {
                        return mCanScroll;
                    }
                };
                break;
        }
    }

    private int getColor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getContext().getColor(id);
        } else {
            return getResources().getColor(id);
        }
    }

    public enum LayoutMangerType {
        LINEAR_VERTICAL, LINEAR_HORIZONTAL, GRID
    }
}
