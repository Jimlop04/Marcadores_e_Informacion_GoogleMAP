package com.example.marcadores_e_informacion_googlemap

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ModelFacultad (a: JSONObject) {
    var id:String
    var facultad:String
    var decano:String
    var latitud:Double
    var longitud:Double
    var logo:String
    var descripcion:String
    var ubicacion:String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<ModelFacultad> {
            val usuarios: ArrayList<ModelFacultad> = ArrayList<ModelFacultad>()
            var i = 0
            while (i < datos.length()) {
                usuarios.add(ModelFacultad(datos.getJSONObject(i)))
                i++
            }
            return usuarios
        }

    }
    init {
        id=a.getString("id").toString()
        facultad=a.getString("Facultad").toString()
        decano=a.getString("Decano").toString()
        latitud=a.getDouble("Latitud")
        longitud=a.getDouble("Longitud")
        logo=a.getString("Logo").toString()
        descripcion=a.getString("Descripcion").toString()
        ubicacion=a.getString("Ubicacion").toString()
    }
}