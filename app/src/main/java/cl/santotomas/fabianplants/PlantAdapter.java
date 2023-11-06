package cl.santotomas.fabianplants;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// PlantAdapter.java
public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {
    private List<Planta> plantList; //gd g
    private OnItemClickListener listener; //DFSDFSDF

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PlantAdapter(List<Planta> plantList) {
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_plant_item, parent, false);
        return new PlantViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Planta planta = plantList.get(position);
        holder.nombreTextView.setText(planta.getNombre());
        holder.descripcionTextView.setText(planta.getDescripcion());
        holder.descripcionTextView.setVisibility(View.GONE); // Inicialmente oculta la descripción
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }

    public class PlantViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView descripcionTextView;

        public PlantViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            // Alternar la visibilidad de la descripción
                            if (descripcionTextView.getVisibility() == View.VISIBLE) {
                                descripcionTextView.setVisibility(View.GONE);
                            } else {
                                descripcionTextView.setVisibility(View.VISIBLE);
                            }
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
