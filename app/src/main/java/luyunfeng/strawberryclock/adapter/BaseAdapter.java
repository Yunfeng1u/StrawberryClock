package luyunfeng.strawberryclock.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

import com.wannar.wannar_adroid2.util.kotlin_extentions.ViewExtKt;

import java.util.List;

/**
 * Created by luyunfeng on 16/8/4.
 */
public abstract class BaseAdapter<t> extends RecyclerView.Adapter<BaseViewHolder> {

    private SparseIntArray layoutMap;
    @LayoutRes
    private int layoutId;
    protected List<t> list;
    protected OnListItemClickListener<t> listener;

    protected BaseAdapter() {
        //空实现，调用此方法请重写onCreateViewHolder
    }

    // 单种类型
    protected BaseAdapter(@LayoutRes int layoutId, List<t> list) {
        this.layoutId = layoutId;
        this.list = list;
    }

    // 多种类型
    protected BaseAdapter(SparseIntArray layoutMap, List<t> list) {
        this.layoutMap = layoutMap;
        this.list = list;
    }

    // 多种类型，viewType = 布局id
    protected BaseAdapter(List<t> list) {
        this.list = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        if (layoutId != 0) {
            layout = layoutId;
        } else if (layoutMap != null) {
            layout = layoutMap.get(viewType);
        } else {
            layout = viewType;
        }
        return new BaseViewHolder(ViewExtKt.inflateView(parent, layout));
    }

    protected abstract void convert(BaseViewHolder holder, t entity);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position < list.size()) {
            convert(holder, list.get(position));
        } else {
            convert(holder, null);
        }
    }

    protected void setClickEvent(BaseViewHolder holder, int viewId, final t entity) {
        if (listener != null) {
            holder.setOnClickListener(viewId, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(entity);
                }
            });
        }
    }

    protected void setClickEvent(BaseViewHolder holder, final t entity) {
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(entity);
                }
            });
        }
    }

    public List<t> getList() {
        return list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnListItemClickListener<t> listener) {
        this.listener = listener;
    }

    public interface OnListItemClickListener<t> {
        void onItemClicked(t entity);
    }
}
