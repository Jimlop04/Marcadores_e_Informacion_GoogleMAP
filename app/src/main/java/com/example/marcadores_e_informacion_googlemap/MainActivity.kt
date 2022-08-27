package com.example.marcadores_e_informacion_googlemap

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap2: GoogleMap
    private var mapFragment: SupportMapFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpMap()
    }
    private fun setUpMap(){
        mapFragment=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {

        val sydney1 = LatLng(-1.0806393666468161, -79.50239673786432)
        val sydney2 = LatLng(-1.0796695, -79.5025683)

        val markerView= (getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.cardview_info, null)
        val facu = markerView.findViewById<TextView>(R.id.txtFacu)
        val cardView = markerView.findViewById<CardView>(R.id.markerCardView)
        val decano = markerView.findViewById<TextView>(R.id.txtDecano)

        facu.text="FACULTAD DE CIENCIAS PECUARIAS"
        decano.text="Decano: Ítalo Espinoza, PhD"
        val bitmap1= Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon1=BitmapDescriptorFactory.fromBitmap(bitmap1)
        googleMap.addMarker(MarkerOptions().position(sydney1).icon(smallMarkerIcon1))

        facu.text="FACULTAD DE CIENCIAS DE LA INGENIERÍA"
        decano.text="Decano: Washington Chiriboga, M.Sc"
        val bitmap2= Bitmap.createScaledBitmap(viewToBitmap(cardView)!!, cardView.width, cardView.height, false)
        val smallMarkerIcon2=BitmapDescriptorFactory.fromBitmap(bitmap2)
        googleMap.addMarker(MarkerOptions().position(sydney2).icon(smallMarkerIcon2))
    }
    private fun viewToBitmap(view: View):Bitmap?{
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val bitmap=Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas= Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }
}