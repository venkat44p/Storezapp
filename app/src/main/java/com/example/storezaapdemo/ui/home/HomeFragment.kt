package com.example.storezaapdemo.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.storezaapdemo.R
import com.example.storezaapdemo.databinding.FragmentHomeBinding
import com.example.storezaapdemo.ui.store.StoreFragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Get a reference to the ImageSlider view
        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()


        val amazonImage = view.findViewById<ImageView>(R.id.amazonIv)

        amazonImage.setOnClickListener {
            val intent = Intent(activity, StoreFragment::class.java)
            startActivity(intent)
        }

        val imageView = view.findViewById<ImageView>(R.id.flipkartIv_1)
        val url = "https://www.flipkart.com/offers-store?affid=ashishsmx&pk=dotd"

        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val imageView1 = view.findViewById<ImageView>(R.id.flipkartIv_2)
        val url1 = "https://www.flipkart.com/offers-store?affid=ashishrgu&pk=dotd"

        imageView1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
            startActivity(intent)
        }

        val imageView2 = view.findViewById<ImageView>(R.id.flipkartIv_3)
        val url2 = "https://www.flipkart.com/offers-store?affid=ashishrgu&pk=dotd"

        imageView2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url2))
            startActivity(intent)
        }


        val imageView3 = view.findViewById<ImageView>(R.id.amazonIv_1)
        val url3 = "https://www.amazon.in/gp/goldbox?ref_=as_acmain_dotd&tag=storezaapcom-21"

        imageView3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url3))
            startActivity(intent)
        }

        val imageView4 = view.findViewById<ImageView>(R.id.amazonIv_2)
        val url4 = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"

        imageView4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url4))
            startActivity(intent)
        }

        val imageView5 = view.findViewById<ImageView>(R.id.ebayIv_1)
        val url5 = "https://www.ebay.com/globaldeals/tech"

        imageView5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url5))
            startActivity(intent)
        }

        val imageView6 = view.findViewById<ImageView>(R.id.ebayIv_2)
        val url6 = "https://www.ebay.com/globaldeals/fashion?_sop=2"

        imageView6.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url6))
            startActivity(intent)
        }

        val imageView7 = view.findViewById<ImageView>(R.id.first_cryIv_1)
        val url7 = "https://www.firstcry.com/baby-kids-monthly-shopping-offers"

        imageView7.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url7))
            startActivity(intent)
        }

        val imageView8 = view.findViewById<ImageView>(R.id.first_cryIv_2)
        val url8 = "https://www.firstcry.com/baby-kids-monthly-shopping-offers"

        imageView8.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url8))
            startActivity(intent)
        }

        val imageView9 = view.findViewById<ImageView>(R.id.infibeamIv_1)
        val url9 = "https://www.ia.ooo"

        imageView9.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url9))
            startActivity(intent)
        }

        val imageView10 = view.findViewById<ImageView>(R.id.infibeamIv_2)
        val url10 = "https://www.ia.ooo"

        imageView10.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url10))
            startActivity(intent)
        }

        val imageView11 = view.findViewById<ImageView>(R.id.snapdealIv_1)
        val url11 = "https://www.snapdeal.com/?utm_source=aff_prog&utm_campaign=afts&offer_id=17&aff_id=85120"

        imageView11.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url11))
            startActivity(intent)
        }

        val imageView12 = view.findViewById<ImageView>(R.id.shopcluesIv_1)
        val url12 = "https://bazaar.shopclues.com/?__ar=Y"

        imageView12.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url12))
            startActivity(intent)
        }

        val imageView13 = view.findViewById<ImageView>(R.id.limeroadIv_1)
        val url13 = "https://www.limeroad.com/b1g1"

        imageView13.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url13))
            startActivity(intent)
        }

        val imageView14 = view.findViewById<ImageView>(R.id.amazonIv_3)
        val url14 = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb"

        imageView14.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url14))
            startActivity(intent)
        }


        imageList.add(SlideModel("https://storezaap.com/img/slider/si2.jpg"))
        imageList.add(SlideModel("https://storezaap.com/img/slider/si4.jpg",))
        imageList.add(SlideModel("https://storezaap.com/img/slider/si3.jpg"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        return view
    }

}