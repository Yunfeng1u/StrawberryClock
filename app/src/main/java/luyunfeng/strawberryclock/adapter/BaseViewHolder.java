package luyunfeng.strawberryclock.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.wannar.base_library.text.StringUtils;
import com.wannar.wannar_adroid2.util.kotlin_extentions.ViewExtKt;

/**
 * Created by luyunfeng on 16/8/3.
 */

public class BaseViewHolder extends ViewHolder implements OnClickListener{
    private final SparseArray<View> viewPool = new SparseArray<>();

    public BaseViewHolder(View view) {
        super(view);
    }

    public BaseViewHolder setNullableText(int viewId, String value) {
        if (StringUtils.isEmpty(value)) {
            return setText(viewId, " ");
        } else {
            return setText(viewId, value);
        }
    }

    public BaseViewHolder setNotNullText(int viewId, String value) {
        return setNotNullText(viewId, value, viewId);
    }

    public BaseViewHolder setNotNullText(int viewId, String value, int holderId) {
        if (StringUtils.isEmpty(value)) {
            setVisibility(holderId, View.GONE);
        } else {
            setVisibility(holderId, View.VISIBLE);
            setText(viewId, value);
        }
        return this;
    }

    public BaseViewHolder setText(int viewId, String value) {
        TextView view = this.getView(viewId);
        return setText(view, value);
    }

    public BaseViewHolder setText(TextView view, String value) {
        ViewExtKt.text(view, value);
        return this;
    }

    public BaseViewHolder setText(int viewId, int value) {
        TextView view = this.getView(viewId);
        return setText(view, String.valueOf(value));
    }

    public BaseViewHolder setImageResource(int viewId, int imageResId) {
        ImageView view = this.getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public BaseViewHolder setBackgroundColor(int viewId, int color) {
        View view = this.getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setTextColor(int viewId, int textColor) {
        TextView view = this.getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public BaseViewHolder setVisibility(View view, int visibility) {
        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
        return this;
    }

    public BaseViewHolder setVisibility(int viewId, int visibility) {
        View view = this.getView(viewId);
        return setVisibility(view, visibility);
    }

    public BaseViewHolder setVisibility(int viewId, boolean visible) {
        int visibility = visible ? View.VISIBLE : View.GONE;
        return setVisibility(viewId, visibility);
    }

    public BaseViewHolder setClickable(int viewId, boolean clickable) {
        View view = this.getView(viewId);
        view.setClickable(clickable);
        return this;
    }

    public BaseViewHolder setViewClickListener(OnClickListener listener) {
        itemView.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, OnClickListener listener) {
        View view = this.getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnCheckedChangeListener(int viewId, OnCheckedChangeListener listener) {
        CompoundButton view = this.getView(viewId);
        view.setOnCheckedChangeListener(listener);
        return this;
    }

    public BaseViewHolder setChecked(int viewId, boolean checked) {
        View view = this.getView(viewId);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(checked);
        }
        return this;
    }

    public <T extends View> T getView(int viewId) {
        View view = this.viewPool.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            this.viewPool.put(viewId, view);
        }
        return (T) view;
    }

    @Override
    public void onClick(View v) {

    }
}
