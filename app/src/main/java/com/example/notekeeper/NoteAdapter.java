package com.example.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    Context context;
    List<NoteClass> noteList;
    LayoutInflater inflater;

    NoteAdapter(Context context,List<NoteClass> noteList){
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.note_list_view, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = noteList.get(i).getTitle();
        String date = noteList.get(i).getDate();
        String time = noteList.get(i).getTime();
        String color = noteList.get(i).getColor();

        viewHolder.mTitle.setText(title);
        viewHolder.mDateTime.setText(date + " " + time);
        if (color.equals("noteColor0")) {
            viewHolder.mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.noteColor0));
        } else if (color.equals("noteColor1")) {
            viewHolder.mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.noteColor1));
        } else if (color.equals("noteColor2")) {
            viewHolder.mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.noteColor2));
        } else if (color.equals("noteColor3")) {
            viewHolder.mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.noteColor3));
        } else if (color.equals("noteColor4")) {
            viewHolder.mCardView.setCardBackgroundColor(context.getResources().getColor(R.color.noteColor4));
        }
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle,mDateTime;
        CardView mCardView;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mCardView = itemView.findViewById(R.id.cardView);
            mTitle = itemView.findViewById(R.id.title);
            mDateTime = itemView.findViewById(R.id.dateTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),NoteDetails.class);
                    intent.putExtra("id", noteList.get(getAdapterPosition()).getId());
                    intent.putExtra("title", noteList.get(getAdapterPosition()).getTitle());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public void setFilter(List<NoteClass> newList){
        noteList = new ArrayList<>();
        noteList.addAll(newList);
        notifyDataSetChanged();
    }

//    public NoteAdapter(Context context, List<NoteClass> noteList) {
//        this.context = context;
//        this.noteList = noteList;
//    }
//
//    @Override
//    public int getCount() {
//        return noteList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        Log.d("hello", "hi");
//        if(convertView == null) {
//            viewHolder = new ViewHolder();
//            LayoutInflater inflater = LayoutInflater.from(context);
//            convertView = inflater.inflate(R.layout.note_list_view, parent, false);
//            viewHolder.cardView = (CardView) convertView.findViewById(R.id.cardView);
//            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.title);
//            viewHolder.mDateTime = (TextView) convertView.findViewById(R.id.dateTime);
//            Log.d("noteList Title", noteList.get(position).getTitle());
//            Log.d("noteList DateTime", noteList.get(position).getDate() + " " +
//                    noteList.get(position).getTime());
//            String colorString = noteList.get(position).getColor();
//            if (colorString.equals("noteColor0")) {
//                viewHolder.cardView.setCardBackgroundColor(this.context.getResources().getColor(R.color.noteColor0));
//            } else if (colorString.equals("noteColor1")) {
//                viewHolder.cardView.setCardBackgroundColor(this.context.getResources().getColor(R.color.noteColor1));
//            } else if (colorString.equals("noteColor2")) {
//                viewHolder.cardView.setCardBackgroundColor(this.context.getResources().getColor(R.color.noteColor2));
//            } else if (colorString.equals("noteColor3")) {
//                viewHolder.cardView.setCardBackgroundColor(this.context.getResources().getColor(R.color.noteColor3));
//            } else if (colorString.equals("noteColor4")) {
//                viewHolder.cardView.setCardBackgroundColor(this.context.getResources().getColor(R.color.noteColor4));
//            }
//            viewHolder.mDateTime.setText(noteList.get(position).getDate() + " " +
//                                            noteList.get(position).getTime());
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        return convertView;
//    }

//    private static class ViewHolder {
//
//        CardView cardView;
//        TextView mTitle;
//        TextView mDateTime;
//
//    }
}
