package tpp.pottable.navtab.DatabaseTab;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tpp.pottable.R;
import tpp.pottable.navtab.DatabaseTab.PlantInfoRecyclerView.PlantInfoRecyclerView;

public class CatRecyclerViewDataAdapter extends RecyclerView.Adapter<CatRecyclerViewItemHolder> {

    private List<CatRecyclerViewItem> ItemList;

    public CatRecyclerViewDataAdapter(List<CatRecyclerViewItem> ItemList) {
        this.ItemList = ItemList;
    }


    @Override
    public CatRecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View ItemView = layoutInflater.inflate(R.layout.cardview, parent, false);

        // Create and return our custom Category Recycler View Item Holder object.
        CatRecyclerViewItemHolder ret = new CatRecyclerViewItemHolder(ItemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(CatRecyclerViewItemHolder holder, final int position) {
        if(ItemList!=null) {
            // Get category item dto in list.
            CatRecyclerViewItem Item = ItemList.get(position);

            if(Item != null) {
                // Set category item title.
                holder.getTitleText().setText(Item.getName());
                // Set category image resource id.
                holder.getImageView().setImageResource(Item.getImageId());
                // Set category image description.
                holder.getDescText().setText(Item.getDesc());
                // Set
            }
        }
        holder.plantinfo_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlantInfoRecyclerView.class);
                String categoryID = Integer.toString(position); //lol I hate squeezing
                intent.putExtra("selectedCategoryID", categoryID);
                view.getContext().startActivity(intent);
                }
        });
    }


    @Override
    public int getItemCount() {
        int ret = 0;
        if(ItemList!=null)
        {
            ret = ItemList.size();
        }
        return ret;
    }

}
