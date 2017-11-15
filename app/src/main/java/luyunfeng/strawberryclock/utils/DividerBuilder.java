package luyunfeng.strawberryclock.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wannar.base_library.resource.ResourceHelper;

/**
 * Created by yufeng on 16/8/31.
 */

public class DividerBuilder {

    public final static int MIDDLE = 1;
    public final static int BEGINNING = 2;
    public final static int END = 3;
    public final static int BOTH = 4;

    private int mMode = END;

    private String type = "LinearDecoration";

    private Paint mPaint;
    private Drawable mDivider;

    // 分割线高度
    private int mDividerSize = 3;
    // 分割线边距
    private int mDividerPadding;
    // 方向：LinearLayoutManager.VERTICAL或LinearLayoutManager.HORIZONTAL
    private int mOrientation = LinearLayoutManager.VERTICAL;

    public DividerBuilder setType(String type) {
        if (!type.equals("LinearDecoration") && !type.equals("GridDecoration")) {
            throw new IllegalArgumentException("请输入正确的参数！");
        }
        this.type = type;
        return this;
    }

    public DividerBuilder setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("请输入正确的参数！");
        }
        this.mOrientation = orientation;
        return this;
    }

    public DividerBuilder setDivider(Drawable drawable) {
        mDivider = drawable;
        return this;
    }

    public DividerBuilder setDivider(@ColorRes int dividerColor) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(ResourceHelper.getColor(dividerColor));
        mPaint.setStyle(Paint.Style.FILL);
        return this;
    }

    public DividerBuilder setDividerSize(int dividerSize) {
        this.mDividerSize = dividerSize;
        return this;
    }

    public DividerBuilder setDividerSizeRes(@DimenRes int dimen) {
        this.mDividerSize = ResourceHelper.getDimensionPixelSize(dimen);
        return this;
    }

    public DividerBuilder setDividerPadding(int dividerPadding) {
        this.mDividerPadding = dividerPadding;
        return this;
    }

    public DividerBuilder setDividerPaddingRes(@DimenRes int dimen) {
        this.mDividerPadding = ResourceHelper.getDimensionPixelSize(dimen);
        return this;
    }

    public DividerBuilder setMode(int mode) {
        mMode = mode;
        return this;
    }

    public RecyclerView.ItemDecoration build() {
        if (type.equals("LinearDecoration")) {
            return new LinearDecoration();
        } else {
            return new GridDecoration();
        }
    }

    private class LinearDecoration extends RecyclerView.ItemDecoration {

        //获取分割线尺寸
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.setEmpty();
            if (mOrientation == LinearLayoutManager.VERTICAL) {
                switch (mMode) {
                    case MIDDLE:
                        if (parent.getChildAdapterPosition(view) < parent.getChildCount()) {
                            outRect.bottom = mDividerSize;
                        }
                        break;
                    case END:
                        outRect.bottom = mDividerSize;
                        break;
                    case BEGINNING:
                        int position = parent.getChildAdapterPosition(view);
                        if (position == 0) {
                            outRect.bottom = mDividerSize;
                            outRect.top = mDividerSize;
                        } else if (position < parent.getChildCount()) {
                            outRect.bottom = mDividerSize;
                        }
                        break;
                    case BOTH:
                        if (parent.getChildAdapterPosition(view) == 0) {
                            outRect.bottom = mDividerSize;
                            outRect.top = mDividerSize;
                        } else {
                            outRect.bottom = mDividerSize;
                        }
                        break;
                }
            } else {
                switch (mMode) {
                    case MIDDLE:
                        if (parent.getChildAdapterPosition(view) < parent.getChildCount()) {
                            outRect.right = mDividerSize;
                        }
                        break;
                    case END:
                        outRect.right = mDividerSize;
                        break;
                    case BEGINNING:
                        int position = parent.getChildAdapterPosition(view);
                        if (position == 0) {
                            outRect.right = mDividerSize;
                            outRect.left = mDividerSize;
                        } else if (position < parent.getChildCount()) {
                            outRect.right = mDividerSize;
                        }
                        break;
                    case BOTH:
                        if (parent.getChildAdapterPosition(view) == 0) {
                            outRect.right = mDividerSize;
                            outRect.left = mDividerSize;
                        } else {
                            outRect.right = mDividerSize;
                        }
                        break;
                }
            }
        }

        //绘制分割线
        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
            if (mDivider == null && mPaint == null) {
                return;
            }
            if (mOrientation == LinearLayoutManager.VERTICAL) {
                drawVertical(c, parent);
            } else {
                drawHorizontal(c, parent);
            }
        }

        private void drawVertical(Canvas canvas, RecyclerView parent) {
            final int left = parent.getPaddingLeft() + mDividerPadding;
            final int right = parent.getMeasuredWidth() - parent.getPaddingRight() - mDividerPadding;
            final int childSize = parent.getChildCount();
            for (int i = 0; i < childSize; i++) {
                final View child = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + layoutParams.bottomMargin;
                final int bottom = top + mDividerSize;
                drawDivider(canvas, left, top, right, bottom, layoutParams.getViewAdapterPosition(), childSize);
            }
        }

        private void drawHorizontal(Canvas canvas, RecyclerView parent) {
            final int top = parent.getPaddingTop() + mDividerPadding;
            final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom() - mDividerPadding;
            final int childSize = parent.getChildCount();
            for (int i = 0; i < childSize; i++) {
                final View child = parent.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int left = child.getRight() + layoutParams.rightMargin;
                final int right = left + mDividerSize;
                drawDivider(canvas, left, top, right, bottom, layoutParams.getViewAdapterPosition(), childSize);
            }
        }

        private void drawDivider(Canvas canvas, int left, int top, int right, int bottom, int position, int count) {

            switch (mMode) {
                case MIDDLE:
                    if (position < count-1) {
                        drawDivider(canvas, left, top, right, bottom);
                    }
                    break;
                case END:
                    drawDivider(canvas, left, top, right, bottom);
                    break;
                case BEGINNING:
                    if (position < count - 1) {
                        drawDivider(canvas, left, top, right, bottom);
                    }
                    break;
                case BOTH:
                    drawDivider(canvas, left, top, right, bottom);
                    break;
            }
        }

        private void drawDivider(Canvas canvas, int left, int top, int right, int bottom){
            if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }
            if (mPaint != null) {
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    private class GridDecoration extends RecyclerView.ItemDecoration {
        private int outerPadding = 32;
        private int innerPadding = 16;

        GridDecoration(){
            this.outerPadding = mDividerSize;
            this.innerPadding = mDividerSize / 2;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            int position = parent.getChildAdapterPosition(view);

            final GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = layoutManager.getSpanSizeLookup();

            // Zero everything out for the common case
            outRect.setEmpty();

            // 该项占位大小
            int spanSize = spanSizeLookup.getSpanSize(position);
            // 总共多少列
            int spanCount = layoutManager.getSpanCount();
            // 在第几列
            int spanIndex = spanSizeLookup.getSpanIndex(position, spanCount);

            outRect.bottom = outerPadding;

            // 第一行
            if (mMode == BOTH){
                if (position < spanCount) {
                    outRect.top = outerPadding;
                }
            }

            if (spanSize == spanCount) {
                // Only item in row - 只有一列
                outRect.left = outerPadding;
                outRect.right = outerPadding;
            } else if (spanIndex == 0) {
                // First item in row - 第一列
                outRect.left = outerPadding;
                outRect.right = innerPadding;
            } else if (spanIndex == spanCount - 1) {
                // Last item in row - 最后一列
                outRect.left = innerPadding;
                outRect.right = outerPadding;
            } else {
                // Inner item (not relevant for less than three columns) - 内部项
                outRect.left = innerPadding;
                outRect.right = innerPadding;
            }
        }
    }
}
