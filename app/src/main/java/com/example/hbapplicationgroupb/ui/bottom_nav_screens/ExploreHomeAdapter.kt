package com.example.hbapplicationgroupb.ui.bottom_nav_screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hbapplicationgroupb.R
import com.example.hbapplicationgroupb.databinding.RecyclerviewRowBinding
import com.example.hbapplicationgroupb.model.topDealAndHotel.TopDealAndHotelData
import com.example.hbapplicationgroupb.model.topDealAndHotel.TopDealsAndHotel
import com.example.hbapplicationgroupb.ui.tophotels.TopHotelClickListener

class ExploreHomeAdapter() :
    RecyclerView.Adapter<ExploreHomeAdapter.HotelsViewHolder>() {
    private lateinit var mlistener: TopItemClickListener

    private var hotels: List<TopDealAndHotelData> = listOf()
    fun populateHotels(list: List<TopDealAndHotelData>) {
        this.hotels = list
        notifyDataSetChanged()
    }


    class HotelsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: RecyclerviewRowBinding = RecyclerviewRowBinding.bind(itemView)
        val hotelImage = binding.hotelImage
        val hotelName = binding.hotelName
        val hotelPrice = binding.hotelPrice

        val layout = binding.topHotelLayout

        fun populateHotels(hotelList : TopDealAndHotelData){
            Glide.with(itemView)
                .load(hotelList.thumbnail)
                .into(hotelImage)
            hotelName.text = hotelList.name
            "$${hotelList.price}".also { hotelPrice.text = it }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HotelsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return HotelsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        holder.populateHotels(hotels[position])

        holder.layout.setOnClickListener {
            mlistener.onItemClick(position, hotels[position])
        }
    }

    fun topHotelClickListener(topHotelClickListener: TopItemClickListener) {
        mlistener = topHotelClickListener
    }

    override fun getItemCount(): Int {
        return hotels.size
    }
}


interface TopItemClickListener {
    fun onItemClick(position: Int, objectData: TopDealAndHotelData)

}