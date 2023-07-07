package com.rtb.bemonetise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.rtb.bemonetise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var interstitialAd: InterstitialAd? = null
    private var rewardedInterstitialAd: RewardedInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        loadAd()
    }

    private fun loadAd() {
        val adRequest = AdManagerAdRequest.Builder().addCustomTargeting("hb_format", "amp").build()
        binding.bannerAd.loadAd(adRequest)
    }



    override fun onResume() {
        super.onResume()
        binding.bannerAd.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.bannerAd.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.bannerAd.destroy()
    }
}