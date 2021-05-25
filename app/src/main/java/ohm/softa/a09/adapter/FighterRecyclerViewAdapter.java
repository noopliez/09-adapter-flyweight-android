package ohm.softa.a09.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ohm.softa.a09.R;
import ohm.softa.a09.model.Fighter;

public class FighterRecyclerViewAdapter extends RecyclerView.Adapter<FighterRecyclerViewAdapter.ViewHolder> {
    private final List<Fighter> localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView fighterImageView;
        private final TextView pilotNameView;
        private final TextView fighterTypeView;

        public ViewHolder(View view) {
            super(view);

            fighterImageView = (ImageView) view.findViewById(R.id.fighterImageView);
            pilotNameView = (TextView) view.findViewById(R.id.pilotNameView);
            fighterTypeView = (TextView) view.findViewById(R.id.fighterTypeView);
        }

        public ImageView getFighterImageView() {
            return fighterImageView;
        }

        public TextView getPilotNameView() {
            return pilotNameView;
        }

        public TextView getFighterTypeView() {
            return fighterTypeView;
        }
    }

    public FighterRecyclerViewAdapter(List<Fighter> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fighter_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FighterRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.getFighterImageView().setImageDrawable(localDataSet.get(position).getFighterImage());
        holder.getFighterTypeView().setText(localDataSet.get(position).getFighterType());
        holder.getPilotNameView().setText(localDataSet.get(position).getPilot());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
