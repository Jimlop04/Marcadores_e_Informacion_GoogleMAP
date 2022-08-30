package com.example.marcadores_e_informacion_googlemap

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso


class InfoWindowAdapter(val context: Context): GoogleMap.InfoWindowAdapter, OnMapReadyCallback {
    lateinit var mMap:GoogleMap
    lateinit var position:LatLng
    override fun getInfoContents(marker: Marker): View? {
        var infoView:View=LayoutInflater.from(context).inflate(R.layout.informacion_facultad,null)
        val facultad:TextView=infoView.findViewById(R.id.txtFacu)
        val latitud:TextView=infoView.findViewById(R.id.txtLatitud)
        val longitud:TextView=infoView.findViewById(R.id.txtLongitud)
        val ubicacion:TextView=infoView.findViewById(R.id.txtDir)
        val decano:TextView=infoView.findViewById(R.id.txtDecano)
        val descripcion:TextView=infoView.findViewById(R.id.txtDescripcion)
        val logo:ImageView=infoView.findViewById(R.id.markerImagen)
        var datos:ModelFacultad= marker.tag as ModelFacultad
        Picasso.get().load(datos.logo).into(logo)
        facultad.text=datos.facultad
        decano.text=datos.decano
        latitud.text=datos.latitud.toString()
        longitud.text=datos.longitud.toString()
        ubicacion.text=datos.ubicacion
        descripcion.text=datos.descripcion

        return infoView
    }
    fun marcadores(point: ArrayList<ModelFacultad>) {
        for (i in 0 until point.size) {
            val datos: ModelFacultad = point[i]
            val map = mMap.addMarker(
                MarkerOptions().position(LatLng(datos.latitud, datos.longitud))
                    .title(datos.facultad)
                    .snippet(datos.descripcion)
            )
            map!!.tag = datos
            position=LatLng(datos.latitud,datos.longitud)
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position,18f))
            mMap.mapType=GoogleMap.MAP_TYPE_SATELLITE
        }

    }

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap=googleMap
        mMap.uiSettings.isZoomControlsEnabled=true
        mMap.setInfoWindowAdapter(this)
    }
}