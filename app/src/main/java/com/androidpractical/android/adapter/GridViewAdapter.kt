package com.androidpractical.android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

import android.widget.RelativeLayout

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView

import androidx.recyclerview.widget.RecyclerView
import com.androidpractical.android.R
import com.androidpractical.android.model.ListModel
import com.bumptech.glide.Glide
import com.google.android.material.textview.MaterialTextView

class GridViewAdapter(
    private val context: Context?,
    private val mList: ArrayList<ListModel>
) : BaseAdapter() {

    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Any {
        return mList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = if (convertView == null) {
            val inflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.custom_coin_layout, parent, false)
        } else {
            convertView
        }

        val coinText: MaterialTextView = view.findViewById(R.id.coin_text)
        val coinImage: AppCompatImageView = view.findViewById(R.id.coin_image)

        coinText.text = mList[position].name
        Glide.with(context!!)
            .load(mList[position].pictureModel?.frontModel?.url)
            .into(coinImage)

        return view
    }
}