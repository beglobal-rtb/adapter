package com.rtb.bemonetise

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdRequest
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
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
        loadInterstitial()
    }

    private fun loadAd() {
        val adRequest = AdManagerAdRequest.Builder().addCustomTargeting("hb_format", "amp").build()
        binding.bannerAd.loadAd(adRequest)
    }


    private fun loadInterstitial(){
        val adRequest = AdManagerAdRequest.Builder().build()
        InterstitialAd.load(this, "/21952429235,21952429235/be_sun_com.livecameracctv.videocamerarecorder_appinterstitial1", adRequest, object: InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(p0: LoadAdError) {
                Log.d("Ads", "onAdFailedToLoad: $p0")
            }

            override fun onAdLoaded(p0: InterstitialAd) {
                super.onAdLoaded(p0)
                Log.d("Ads", "onAdLoaded:")
            }
        })
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