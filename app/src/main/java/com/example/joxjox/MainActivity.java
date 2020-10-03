package com.example.joxjox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // สร้าง Layout manager
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        // สร้าง Adapter object
        MyAdapter adapter = new MyAdapter();

        // เข้าถึง  RecyclerView ใน layout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
        rv.setAdapter(adapter); // กำหนด adapter ให้กับ RecyclerView
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private WordItem[] items = {
                 new WordItem(R.drawable.nurat,"Nurat","ไม่เชื่อมาดูบัตรประชาชน "),
                new WordItem(R.drawable.bear,"Bear","ยำเจ๊โส "),
                new WordItem(R.drawable.petch,"Petch","เพชรเฉ๊บ "),
                new WordItem(R.drawable.jj,"พระมหาเทวี","เจ๊อย่าวีน "),
                new WordItem(R.drawable.sitang,"Sitang","ฝันที่แม่เคยฝัน "),
            new WordItem(R.drawable.basty,"Basty","หมายเลข 79 "),
            new WordItem(R.drawable.toon,"Toon","หิ้วหวี 1 "),
            new WordItem(R.drawable.mix,"Mix","หิ้วหวี 2 "),
            new WordItem(R.drawable.nutt,"Nut","หิ้วหวี 3 "),
            new WordItem(R.drawable.pai,"Prai","คุณคือนักร้องเสียงเพี้ยน ")

    };

    MyAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.wordTextView.setText(items[position].word);
        holder.word2.setText(items[position].word2);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView wordTextView;
        TextView word2;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            word2=itemView.findViewById(R.id.textView2);
        }
    }
}