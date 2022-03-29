package com.example.sampleconstraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data Layout inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arraylist;

    //Membuat konstruktor Listviewadapter
    public ListViewAdapter(Context context) {
        //Memberi nilai mContext dengan context
        mContext = context;

        //Mengatur layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arraylist dari class ClassNama
        this.arraylist = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arraylist
        this.arraylist.addAll(Home_Activity.classNamaArrayList);
    }

    //Membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam Listview
    public  class ViewHolder {
        TextView name;
    }

    //Fungsi getcount () mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }

    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    // tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi
    // tertentu dalam pengumpulan data item.
    @Override
    public Object getItem(int i) {
        //Mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi item ke adaptor.
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    // ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Deklarasi variabel dengan jenis data viewholder
        final ViewHolder holder;

        //Membuat kondisi apakah view null atau tidak
        if (view == null) {
            //Membuat objek view holder
            holder = new ViewHolder();

            //Mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //Set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //Menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        } else {
            //Mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //Set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //Mengembalikan nilai ke variabel view
        return view;
    }
}