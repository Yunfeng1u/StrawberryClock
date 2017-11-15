package luyunfeng.strawberryclock.utils;

import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.wannar.base_library.resource.ResourceHelper;

import luyunfeng.strawberryclock.R;
import luyunfeng.strawberryclock.global.MyApplication;

/**
 * Created by luyunfeng on 15/10/19.
 * 控件相关实用类
 */
public class ViewHelper {

    public static void scrollToTop(final View scroll) {
        if (scroll == null) {
            return;
        }
        scroll.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (scroll instanceof ScrollView) {
                    ((ScrollView) scroll).smoothScrollTo(0, 0);
                } else if (scroll instanceof NestedScrollView) {
                    ((NestedScrollView) scroll).smoothScrollTo(0, 0);
                } else if (scroll instanceof RecyclerView) {
                    ((RecyclerView) scroll).smoothScrollToPosition(0);
                }
            }
        }, 100);
    }

    public static void setSpaceDivider(RecyclerView recyclerView) {
        if (recyclerView.getTag() == null) {
            RecyclerView.ItemDecoration itemDecoration =
                    new DividerBuilder()
                            .setType("GridDecoration")
                            .setDividerSizeRes(R.dimen.medium_1_space)
                            .build();
            recyclerView.addItemDecoration(itemDecoration);
            recyclerView.setTag(itemDecoration);
        }
    }

    public static RecyclerView.ItemDecoration getDivider() {
        return new DividerBuilder()
                .setDividerSizeRes(R.dimen.small_divider_height)
                .setDivider(R.color.light_grey_color)
                .build();
    }

    public static RecyclerView.ItemDecoration getLargeDivider() {
        return new DividerBuilder()
                .setDividerSizeRes(R.dimen.small_2_space)
                .setDivider(R.color.light_grey_color)
                .build();
    }

    public static RecyclerView getNestRecyclerView(View view) {
        return getNestRecyclerView(view, 0);
    }

    /**
     * ScrollView嵌套列表
     *
     * @param view
     * @param spanCount
     * @return
     */
    public static RecyclerView getNestRecyclerView(View view, int spanCount) {

        if (!(view instanceof RecyclerView)) {
            return null;
        }

        RecyclerView rv = (RecyclerView) view;
        rv.setNestedScrollingEnabled(false);
        rv.setFocusable(false);
        rv.setFocusableInTouchMode(false);

        if (spanCount > 1) {
            rv.setLayoutManager(new GridLayoutManager(MyApplication.getContext(), spanCount) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
        } else {
            rv.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
        }
        return rv;
    }


    public static void textSizeFit(int length, TextView tv_title) {
        if (length > 10) {
            tv_title.setTextSize(ResourceHelper.getSpPixelSize(R.dimen.small_3_text_size));
        } else if (length > 8) {
            tv_title.setTextSize(ResourceHelper.getSpPixelSize(R.dimen.small_4_text_size));
        } else if (length > 6) {
            tv_title.setTextSize(ResourceHelper.getSpPixelSize(R.dimen.small_5_text_size));
        } else {
            tv_title.setTextSize(ResourceHelper.getSpPixelSize(R.dimen.normal_1_text_size));
        }
    }

    public static void addTab(TabLayout tl_item_type, Object tag, String text) {
        tl_item_type.addTab(tl_item_type.newTab().setTag(tag).setText(text));
    }

    public static void addTab(TabLayout tl_item_type, Object tag, @StringRes int textId) {
        addTab(tl_item_type, tag, ResourceHelper.getString(textId));
    }

}
