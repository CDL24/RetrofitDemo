package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.climbachiya.retrofitdemo.R;

import java.util.List;

import modals.JsonListItem;

/**
 * Created by C.limbachiya on 6/1/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    List<JsonListItem> result = null;
    Context mContext;

    public MyRecyclerAdapter(Context context, List<JsonListItem> _result) {
        this.result = _result;
        this.mContext = context;
    }

    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.ViewHolder holder, final int position) {
        JsonListItem item = result.get(position);

        holder.textTitle.setText(item.getTitle());
        holder.textLink.setText(item.getLink());

        Glide
            .with(mContext)
            .load(item.getOwner().getProfile_image())
            .centerCrop()
            .placeholder(android.R.drawable.ic_dialog_alert)
            .crossFade()
            .into(holder.imgIcon);

        Log.v("Tags : position :: "+position, ""+item.getTags().size());

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle;
        public TextView textLink;
        public ImageView imgIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            textLink = (TextView) itemView.findViewById(R.id.text_link);
            imgIcon = (ImageView) itemView.findViewById(R.id.image_icon);

        }
    }

    /**
     * Edit record in database
     * @param position - row position in array list
     */
    /*private void editRow(int position) {
        String rowId = items.get(position).getId();
        Intent intentEdit = new Intent(mContext, MainActivity.class);
        intentEdit.putExtra("ROW_ID", rowId);
        mContext.startActivity(intentEdit);
        ((Activity)mContext).finish();
    }*/

    //Remove item
   /* public void removeItem(int position) {
        DatabaseHandler dbHandler = DatabaseHandler.getInstance(mContext);
        try {
            String rowId = items.get(position).getId();

            String whereClause = DatabaseHandler.KEY_ID+" = ?";
            String[] whereArgs = new String[]{rowId};
            int result = dbHandler.deleteRecord(DatabaseHandler.TABLE_CONTACTS, whereClause, whereArgs);

            if(result > 0){
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, items.size());
                items.remove(position);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != dbHandler){
                dbHandler.close();
            }
        }

    }*/
}